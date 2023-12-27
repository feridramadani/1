package org.example.services;

import org.example.database.DatabaseConnection;
import org.example.database.OrderSQL;
import org.example.domain.Order;
import org.example.domain.OrderItem;
import org.example.domain.Product;

import javax.ws.rs.BadRequestException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class OrderService {

    public Order getOrder(String id) throws Exception {
        Order order = null;
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(OrderSQL.GET_ORDER_BY_ID);
            statement.setString(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                if (order == null) {
                    order = new Order(rs);
                }
                OrderItem orderItem = new OrderItem();
                orderItem.setProductId(rs.getString("oi.product_id"));
                orderItem.setQuantity(rs.getInt("oi.quantity"));
                order.getOrderItems().add(orderItem);
            }
        } finally {
            rs.close();
            statement.close();
            conn.close();
        }
        return order;
    }

//    public List<Order> getOrder(String id) throws Exception {
//        ResultSet rs = null;
//        PreparedStatement statement = null;
//        Connection conn = null;
//        try {
//            conn = DatabaseConnection.getInstance().getConnection();
//            statement = conn.prepareStatement(OrderSQL.GET_ORDER_BY_ID);
//            statement.setString(1, id);
//            rs = statement.executeQuery();
//            List<Order> orders = new ArrayList<>();
//            while (rs.next()) {
//                orders.add(new Order(rs));
//            }
//            statement.close();
//            conn.close();
//            return orders;
//        } finally {
//            rs.close();
//            statement.close();
//            conn.close();
//        }
//    }

    //    private HashMap<String, Product> getMappedProducts() throws Exception {
//        // da bojsh named parameter statment plus query sende vende
//        HashMap<String, Product> map = new HashMap<>();
//
//        //mbrenda while() map.computeIfAbsent(productId, t -> new Product(rs, alias));
//        return map;
//    }
    public void createOrder(Order order) throws Exception {
        if (order == null) {
            throw new BadRequestException("Invalid payload");
        }
        if (order.getGuestName() == null || order.getGuestName().isEmpty()) {
            order.setGuestName("Customer");
        }
        if (order.getOrderItems() == null || order.getOrderItems().isEmpty()) {
            throw new BadRequestException("Invalid order Items");
        }
        HashMap<String, Product> map = new ProductService().getAllProductsMapped();
        for (OrderItem orderItem : order.getOrderItems()) {
            Product product = map.get(orderItem.getProductId());
            if (product == null) {
                throw new BadRequestException("Invalid product on payload");
            }
            if (!product.isActivate()) {
                throw new BadRequestException("Inactive product on payload");
            }
            if (orderItem.getMenuId() != null && !product.getMenuId().equals(orderItem.getMenuId())) {
                throw new BadRequestException("Invalid menu id on payload");
            }
            if (orderItem.getQuantity() <= 0) {
                throw new BadRequestException("Invalid quantity");
            }
        }
        order.setId(UUID.randomUUID().toString());
        PreparedStatement statement = null;
        PreparedStatement orderItemStmt = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(OrderSQL.CREATE_ORDER);
            statement.setString(1, order.getId());
            statement.setString(2, order.getOrderNumber());
            statement.setDouble(3, order.getTotalCharges());
            statement.setString(4, order.getStatus());
            statement.setString(5, order.getGuestName());
            statement.executeUpdate();

            orderItemStmt = conn.prepareStatement(OrderSQL.ADD_ORDER_ITEM);
            for (OrderItem orderItem : order.getOrderItems()) {
                orderItem.setId(UUID.randomUUID().toString());
                orderItemStmt.setString(1, orderItem.getId());
                orderItemStmt.setString(2, orderItem.getProductId());
                orderItemStmt.setString(3, order.getId());
                orderItemStmt.setDouble(4, orderItem.getChargeAmount());
                orderItemStmt.setString(5, orderItem.getStatus().name());
                orderItemStmt.setInt(6, orderItem.getQuantity());
                orderItemStmt.addBatch();
            }
            orderItemStmt.executeBatch();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            statement.close();
            orderItemStmt.close();
            conn.close();
        }
    }

    public boolean deleteOrder(String id) throws Exception {
        boolean isCreated;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(OrderSQL.DELETE_ORDER);
            statement.setString(1, id);
            isCreated = statement.executeUpdate() == 1;

        } finally {
            statement.close();
            conn.close();
        }
        return isCreated;
    }

    public boolean updateOrder(Order order) throws Exception {
        boolean isUpdated = false;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(OrderSQL.UPDATE_ORDER);
            statement.setString(1, order.getId());
            statement.setString(2, order.getOrderNumber());
            statement.setDouble(3, order.getTotalCharges());
            statement.setString(4, order.getStatus());
            isUpdated = statement.executeUpdate() == 1;
        } finally {
            statement.close();
            conn.close();
        }
        return isUpdated;
    }

    public List<Order> getAllOrders() throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(OrderSQL.GET_ALL_ORDERS);
            rs = statement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (rs.next()) {
                orders.add(new Order(rs));
            }
            statement.close();
            conn.close();
            return orders;
        } finally {
            rs.close();
            statement.close();
            conn.close();
        }
    }
}
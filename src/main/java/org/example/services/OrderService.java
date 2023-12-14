package org.example.services;

import org.example.database.*;
import org.example.domain.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService {

    public Order getOrder(String id) throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(OrderSQL.GET_ORDER_BY_ID);
            statement.setString(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                return new Order(rs);
            }
        } finally {
            rs.close();
            statement.close();
            conn.close();
        }
        return null;
    }

    public boolean createOrder(Order order) throws Exception {
        order.setId(UUID.randomUUID().toString());
        boolean isCreated = false;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(OrderSQL.CREATE_ORDER);
            statement.setString(1, order.getId());
            statement.setString(2, order.getOrderNumber());
            statement.setDouble(3, order.getTotalCharges());
            statement.setString(4, order.getStatus());
            isCreated = statement.executeUpdate() == 1;
        } finally {
            statement.close();
            conn.close();
        }
        return isCreated;
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
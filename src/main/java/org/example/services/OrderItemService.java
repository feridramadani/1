package org.example.services;

import org.example.database.*;
import org.example.domain.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderItemService {

    public OrderItem getOrderItem(String id) throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(OrderSQL.GET_ORDER_ITEM);
            statement.setString(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                return new OrderItem(rs, "");
            }
        } finally {
            rs.close();
            statement.close();
            conn.close();
        }
        return null;
    }

    public void addOrderItem(OrderItem orderItem) throws Exception {
        orderItem.setId(UUID.randomUUID().toString());
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(OrderSQL.ADD_ORDER_ITEM);
            statement.setString(1, orderItem.getId());
            statement.setString(2, orderItem.getProductId());
            statement.setString(3, orderItem.getOrderId());
            statement.setDouble(4, orderItem.getChargeAmount());
            statement.setString(5, orderItem.getStatus().name());
            statement.executeUpdate();
        } finally {
            statement.close();
            conn.close();
        }
    }

    public void deleteOrderItem(String id) throws Exception {
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(OrderSQL.DELETE_ORDER_ITEM);
            statement.setString(1, id);
            statement.executeUpdate();
        } finally {
            statement.close();
            conn.close();
        }
    }

    public void updateOrderItem(OrderItem orderItem) throws Exception {
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(OrderSQL.UPDATE_ORDER_ITEM);
            statement.setString(1, orderItem.getId());
            statement.setString(2, orderItem.getProductId());
            statement.setString(3, orderItem.getOrderId());
            statement.setDouble(4, orderItem.getChargeAmount());
            statement.setString(5, orderItem.getStatus().name());
            statement.executeUpdate();
        } finally {
            statement.close();
            conn.close();
        }
    }

    public List<OrderItem> getAllOrderItems() throws Exception {
        List<OrderItem> orderItems = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(OrderSQL.GET_ALL_ORDER_ITEMS);
            rs = statement.executeQuery();
            while (rs.next()) {
                orderItems.add(new OrderItem(rs, ""));
            }
            return orderItems;
        } finally {
            rs.close();
            statement.close();
            conn.close();
        }
    }
}
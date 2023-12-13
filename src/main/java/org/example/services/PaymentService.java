package org.example.services;

import org.example.database.*;
import org.example.domain.Order;
import org.example.domain.Payment;
import org.example.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaymentService {

    public Payment getPayment(String id) throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(Select.GET_PAYMENT);
            statement.setString(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                return new Payment(rs);
            }
        } finally {
            rs.close();
            statement.close();
            conn.close();
        }
        return null;
    }

    public boolean createPayment(Payment payment) throws Exception {
        payment.setId(UUID.randomUUID().toString());
        boolean isCreated = false;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(Insert.CREATE_PAYMENT);
            statement.setString(1, payment.getId());
            statement.setString(2, payment.getOrder_id());
            statement.setDouble(3, payment.getAmount());
            statement.setString(4, payment.getStatus());
            isCreated = statement.executeUpdate() == 1;
        } finally {
            statement.close();
            conn.close();
        }
        return isCreated;
    }

    public boolean deletePayment(String id) throws Exception {
        boolean isCreated;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(Delete.DELETE_PAYMENT);
            statement.setString(1, id);
            isCreated = statement.executeUpdate() == 1;

        } finally {
            statement.close();
            conn.close();
        }
        return isCreated;
    }

    public boolean updatePayment(Payment payment) throws Exception {
        boolean isUpdated = false;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(Update.UPDATE_PAYMENT);
            statement.setString(1, payment.getId());
            statement.setString(2, payment.getOrder_id());
            statement.setDouble(3, payment.getAmount());
            statement.setString(4, payment.getStatus());
            isUpdated = statement.executeUpdate() == 1;
        } finally {
            statement.close();
            conn.close();
        }
        return isUpdated;
    }

    public List<Payment> getAllPayments() throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(Select.GET_ALL_PAYMENTS);
            rs = statement.executeQuery();
            List<Payment> payment = new ArrayList<>();
            while (rs.next()) {
                payment.add(new Payment(rs));
            }
            statement.close();
            conn.close();
            return payment;
        } finally {
            rs.close();
            statement.close();
            conn.close();
        }
    }
}
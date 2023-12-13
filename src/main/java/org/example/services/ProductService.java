package org.example.services;

import org.example.database.*;
import org.example.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductService {

    public Product getProduct(String id) throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(Select.GET_PRODUCT_BY_ID);
            statement.setString(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                return new Product(rs);
            }
        } finally {
            rs.close();
            statement.close();
            conn.close();
        }
        return null;
    }

    public boolean createProduct(Product product) throws Exception {
        product.setId(UUID.randomUUID().toString());
        boolean isCreated = false;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(Insert.CREATE_PRODUCT);
            statement.setString(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getBase_price());
            statement.setBoolean(4, product.isActivate());
            isCreated = statement.executeUpdate() == 1;
        } finally {
            statement.close();
            conn.close();
        }
        return isCreated;
    }

    public boolean deleteProduct(String id) throws Exception {
        boolean isCreated;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(Delete.DELETE_PRODUCT);
            statement.setString(1, id);
            isCreated = statement.executeUpdate() == 1;

        } finally {
            statement.close();
            conn.close();
        }
        return isCreated;
    }

    public boolean updateProduct(Product product) throws Exception {
        boolean isUpdated = false;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(Update.UPDATE_PRODUCT);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getBase_price());
            statement.setBoolean(3, product.isActivate());
            statement.setString(4, product.getId());
            isUpdated = statement.executeUpdate() == 1;
        } finally {
            statement.close();
            conn.close();
        }
        return isUpdated;
    }

    public List<Product> getAllProducts() throws Exception {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            statement = conn.prepareStatement(Select.GET_ALL_PRODUCTS);
            rs = statement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (rs.next()){
                products.add(new Product(rs));
            }
            statement.close();
            conn.close();
            return products;
        } finally {
            rs.close();
            statement.close();
            conn.close();
        }
    }
}
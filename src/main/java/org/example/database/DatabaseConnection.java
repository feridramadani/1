package org.example.database;

import java.sql.*;

public class DatabaseConnection {
    private static DatabaseConnection connection;

    private DatabaseConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static DatabaseConnection getInstance() {
        if (connection == null) {
            connection = new DatabaseConnection();
        }
        return connection;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/posdb",
                "root", "root");
    }
}

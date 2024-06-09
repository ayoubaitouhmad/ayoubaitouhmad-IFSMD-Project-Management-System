package com.ayoubaitouhmad.demo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/project_management"; // Replace with your database URL
    private String username = "root"; // Replace with your database username
    private String password = ""; // Replace with your database password

    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        if (dbConnection.isConnected()) {
            System.out.println("Database is connected.");
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}

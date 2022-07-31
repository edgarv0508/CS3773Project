package com.example.cs3773project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection databaseLink;

    Connection getConnection() {

        String databaseName = "myshop";
        String url = "jdbc:mysql://localhost/" + databaseName;
        String databaseUser = "root";
        String databasePassword = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return databaseLink;
}


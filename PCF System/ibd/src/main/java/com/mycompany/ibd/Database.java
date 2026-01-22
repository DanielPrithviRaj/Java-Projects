/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ibd;

/**
 *
 * @author LENOVO
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database{

    private static final String URL = "jdbc:mysql://localhost:3306/ibd_form";
    private static final String USER = "root";
    private static final String PASSWORD = "danny";

    public static Connection getConnection() throws SQLException {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC driver not found");
        }
        // Return the connection to the database
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    // Method to check if the connection is successful
    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

   

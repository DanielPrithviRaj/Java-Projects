/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ibd;

import Main.Home;
import java.sql.SQLException; 
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Ibd {

    public static void main(String[] args) throws SQLException {
        testConnection();
       // System.out.println("Hello World!");
        Home.main(args);
 
    }

 private static void testConnection() {
        boolean isConnected = Database.testConnection();
        if (isConnected) {
            //JOptionPane.showMessageDialog(null, "Database connection is successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
        }
    } 
}
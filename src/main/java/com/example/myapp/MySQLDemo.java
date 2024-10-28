package com.example.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class MySQLDemo {
    public static void main(String[] args) {
        // Step 1: Load the JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Establish a Connection
        String url = "jdbc:mysql://localhost:3306/sakila"; // Change to your database
        String username = "root"; // Your MySQL username
        String password = "root"; // Your MySQL password

        try (Connection con = DriverManager.getConnection(url, username, password);
             // Step 3: Create a Statement
             Statement stmt = con.createStatement();
             // Step 4: Execute a Query
             ResultSet rs = stmt.executeQuery("SELECT actor_id, first_name, last_name FROM actor")) {

            // Step 5: Process the Result Set
            while (rs.next()) {
                int actorId = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                System.out.println("Actor ID: " + actorId + ", First Name: " + firstName + ", Last Name: " + lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 6: Close the Resources
        // Resources are closed automatically by the try-with-resources statement
    }
}

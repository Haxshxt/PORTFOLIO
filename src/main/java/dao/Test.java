package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Test {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/myPortfolio";
            String userName = "root";
            String password = "Harshit@08";
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to the database.");

            // Insert a record into the contact table
            String name = "Test Name2 ";
            String email = "test@example.com";
            String message = "This is a test message";
            String time = LocalDateTime.now().toString();

            String sql = "INSERT INTO contact(name, email, message, time) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, message);
            ps.setString(4, time);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new contact was inserted successfully.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

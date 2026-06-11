package com.xworkz.social_media;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccount {
    public static void main(String[] args) {

        System.out.println("Creating social media account...");

        String url = "jdbc:mysql://localhost:3306/social_media_db";
        String userName = "root";
        String password = "root";

        String sqlQuery =
                "insert into social_media values('rahul',300,'snap',120)";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, userName, password);

            statement = connection.createStatement();

            statement.executeUpdate(sqlQuery);

            System.out.println("Data inserted successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                    System.out.println("Statement closed");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

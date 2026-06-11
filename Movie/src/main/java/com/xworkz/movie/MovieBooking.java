package com.xworkz.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieBooking {
    public static void main(String[] args) {
        System.out.println("movie booking....");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url="jdbc:mysql://localhost:3306/movie_db";
        String userName="root";
                String password="root";
        String sqlQuery =
                "insert into movie_info values('milana',2,'cinepolies',900)";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, userName, password);

            statement = connection.createStatement();

            statement.executeUpdate(sqlQuery);

            System.out.println("Movie booking inserted successfully");

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


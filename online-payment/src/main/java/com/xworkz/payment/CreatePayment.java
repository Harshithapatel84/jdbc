package com.xworkz.payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatePayment {

    public static void main(String[] args) {

        System.out.println("payment credited");

        String url = "jdbc:mysql://localhost:3306/payment_db";
        String userName = "root";
        String password = "root";
        String sqlQuery="insert into payment values('56748','riya',670,'credit','2026-06-10')";
        Connection connection=null;
        Statement statement=null;
        try {
             connection=DriverManager.getConnection(url, userName, password);

            System.out.println("Data inserted successfully");
             statement= connection.createStatement();
            statement.execute(sqlQuery);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }try {
            if (statement != null) {
                statement.close();
                System.out.println("Statement closed");
            }

            if (connection != null) {
                connection.close();
                System.out.println("Connection closed");
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}



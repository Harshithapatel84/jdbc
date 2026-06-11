package com.xworkz.payment;

import in.xworkz.payment.DebitPayment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreditPayment {
    public static void main(String[] args) {
        System.out.println("payment credited");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException exception)
        {
            throw new RuntimeException(exception);
        }
        System.out.println("credited payment successfully");

    String url="jdbc:mysql://localhost:3306/testdb";
    String user_name="root";
    String password="root";
    try {
        Connection connection =
                DriverManager.getConnection(url, user_name, password);

        System.out.println("Database connected successfully");

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    DebitPayment.pay();


    }
}

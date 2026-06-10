package com.xworkz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createAccount {
    public static void main(String[] args) {
        System.out.println("creating account..");
        String url = "jdbc:mysql://localhost:3306/bank_db";
        String user_name = "root";
        String password = "root";
        String sqlQuery = "insert into bank_info values('SBI',5,'commercial',20)";
        Connection connect=null;
        Statement statement=null;
        try {
            connect = DriverManager.getConnection(url, user_name, password);
            statement = connect.createStatement();
            statement.execute(sqlQuery);
            System.out.println("data inserted..");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                    System.out.println("connection closed");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(statement!=null)
            {
                try{
                    connect.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

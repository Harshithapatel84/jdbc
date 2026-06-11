package com.xworkz.payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatePayment {
    public static void main(String[] args) throws ClassNotFoundException {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
    }catch
            (ClassNotFoundException e){
            throw  new RuntimeException(e);

        }

        String sqlQuery="update payment set amount=54000 where account_no=56748";

        Connection cn=null;
        Statement statement=null;
        try{
            cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","root");
            statement= cn.createStatement();
            int check=statement.executeUpdate(sqlQuery);
            System.out.println("data updated successfully"+check);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

            if (statement != null) {
                try {
                    statement.close();
                    System.out.println("Statement closed");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (cn != null) {
                try {
                    cn.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

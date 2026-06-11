package com.xworkz.payment;

import java.sql.*;

public class ReadPayment {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection cn=null;
        Statement statement=null;
        ResultSet rs=null;
        String sqlQuery="select*from payment";

        try{
            cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_db","root","root");
           statement= cn.createStatement();
            rs=statement.executeQuery(sqlQuery);
            System.out.println(rs);
            while(rs.next()){
                rs.getString("holder_name");
                while(rs.next()){
                    System.out.println(+rs.getInt("account_no"));
                    System.out.println(rs.getString("holder_name"));
                    System.out.println(rs.getDouble("amount"));
                    System.out.println(rs.getString("payment_type"));
                    System.out.println(rs.getDate("payment_date"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            if(cn!=null)
            {
                try{
                    cn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}

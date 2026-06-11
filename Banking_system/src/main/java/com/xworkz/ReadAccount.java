package com.xworkz;

import java.sql.*;

public class ReadAccount {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sqlQuery="select * from bank_info";
        Connection connect=null;
        Statement statement=null;
        ResultSet rs=null;
        try{
            connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db","root","root");
            statement= connect.createStatement();
            rs=statement.executeQuery(sqlQuery);
            System.out.println(rs);
            while(rs.next())
            {
                System.out.println(rs.getString("bank_name"));
                System.out.println(rs.getInt("counter"));
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally
        {
            if (connect!=null)
            {
                try{
                    connect.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(statement!=null)
            {
                try{
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

}

package com.xworkz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connect=null;
        Statement statement=null;
        String sqlQuery="delete from bank_info where counter=2";
        try{
            connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db","root","root");
            statement= connect.createStatement();
            statement.executeUpdate(sqlQuery);
            System.out.println("deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
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
}

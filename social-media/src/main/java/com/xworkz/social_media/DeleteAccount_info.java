package com.xworkz.social_media;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteAccount_info {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connect=null;
        Statement statement=null;
        String sqlQuery="delete from social_media where followers=5000";
        try{
            connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/social_media_db","root","root");
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




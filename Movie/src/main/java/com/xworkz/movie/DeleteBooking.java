package com.xworkz.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteBooking {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connect=null;
        Statement statement=null;
        String sqlQuery="delete from movie_info where ticket_price=900";
        try{
            connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db","root","root");
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






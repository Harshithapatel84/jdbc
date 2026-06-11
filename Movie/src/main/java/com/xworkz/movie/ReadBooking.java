package com.xworkz.movie;

import java.sql.*;

public class ReadBooking {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connect=null;
        Statement statement=null;
        ResultSet resultSet=null;
        String sqlQuery="select * from movie_info";
        try{
            connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db","root","root");
           statement= connect.createStatement();
            resultSet=statement.executeQuery(sqlQuery);
            System.out.println(resultSet);
            while(resultSet.next())
            {
                System.out.println(resultSet.getString("movie_name"));
                System.out.println(resultSet.getInt("ticket_count"));
                System.out.println(resultSet.getString("theatre_name"));
                System.out.println(resultSet.getInt("ticket_price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            if(connect!=null)
            try{
                connect.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if(statement!=null)
                try{
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }
}

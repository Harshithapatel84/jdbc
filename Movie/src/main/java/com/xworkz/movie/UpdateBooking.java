package com.xworkz.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateBooking {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sqlQuery="update movie_info set movie_name='bahubali' where ticket_count=2";
        Connection cn=null;
        Statement statement=null;
        try{
            cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db","root","root");
            statement= cn.createStatement();
            int update=statement.executeUpdate(sqlQuery);
            System.out.println("data updated successfully"+update);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            if(cn!=null)
                try{
                    cn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            if (statement!=null)
                try{
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }

    }
}

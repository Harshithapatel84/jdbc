package com.xworkz.social_media;

import java.sql.*;

public class ReadAccount {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sqlQuery="select * from social_media";
        Connection connect=null;
        Statement statement=null;
        ResultSet rs=null;
        try{
            connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/social_media_db","root","root");
            statement= connect.createStatement();
            rs=statement.executeQuery(sqlQuery);
            System.out.println(rs);
            while(rs.next())
            {
                System.out.println(rs.getString("user_name"));
                System.out.println(rs.getInt("followers"));
                System.out.println(rs.getInt("posts"));
                System.out.println("display data successfully");
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



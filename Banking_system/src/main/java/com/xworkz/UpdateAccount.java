package com.xworkz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateAccount {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection=null;
        Statement statement=null;
        String sqlQuery="update bank_info set bank_name='mysore Bank' where counter=2 ";
        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db","root","root");
            statement= connection.createStatement();
             int update=statement.executeUpdate(sqlQuery);
            System.out.println("data updated successfully"+update);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(connection!=null)
            {
                try{
                    connection.close();
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

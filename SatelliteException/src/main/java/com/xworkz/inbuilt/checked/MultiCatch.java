package com.xworkz.inbuilt.checked;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MultiCatch {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe_db", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("exception ......");


        }
    }
}

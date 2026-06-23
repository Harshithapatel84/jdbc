package com.xworkz.inbuilt.checked;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MultiplaCatch {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException Occurred");

        } catch (SQLException e) {
            System.out.println("SQLException handled");

        } catch (Exception e) {
            System.out.println("Exception handled");
        }
    }
}
package com.xworkz.project2.dao.impl;

import com.xworkz.project2.dao.HotelDAO;
import com.xworkz.project2.dto.HotelDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HotelDaoImpl implements HotelDAO {
    @Override
    public boolean save(HotelDTO hotelDTO) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connect = null;
        String insertQuery = "Insert into hotell(name, location, type, worker)values(?,?,?,?)";
        String updateQuery="update hotell set worker=150 where location='mysore'";
        String deleteQuery="delete from hotell where name='mayura'";
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotell_db", "root", "root");
            PreparedStatement preparedStatement = connect.prepareStatement(insertQuery);
            preparedStatement.setString(1, hotelDTO.getName());
            preparedStatement.setString(2, hotelDTO.getLocation());
            preparedStatement.setString(3, hotelDTO.getType());
            preparedStatement.setInt(4, hotelDTO.getWorker());
            boolean check = preparedStatement.execute();
            System.out.println("execute returned: " + check);


            PreparedStatement preparedStatement1=connect.prepareStatement(updateQuery);
            int update=preparedStatement1.executeUpdate();
            System.out.println(update);

            PreparedStatement preparedStatement2=connect.prepareStatement(deleteQuery);
            int delete=preparedStatement2.executeUpdate();
            System.out.println(delete);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}

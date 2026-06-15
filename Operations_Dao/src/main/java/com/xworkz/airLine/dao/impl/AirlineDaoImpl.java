package com.xworkz.airLine.dao.impl;

import com.xworkz.airLine.dao.AirlineDAO;
import com.xworkz.airLine.dto.AirlineDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AirlineDaoImpl implements AirlineDAO {
    @Override
    public boolean save(AirlineDTO airlineDTO) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String insertQuery="insert into airline(name, country, type, seating) values(?,?,?,?)";
        String updateQuery="update airline set seating=601 where name='emirates'";
        String deleteQuery="delete from airline where seating=501";


        Connection connection=null;
        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_db", "root", "root");
            PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
            preparedStatement.setString(1,airlineDTO.getName());
            preparedStatement.setString(2,airlineDTO.getCountry());
            preparedStatement.setString(3,airlineDTO.getType());
            preparedStatement.setInt(4,airlineDTO.getSeating_capacity());
            boolean insert=preparedStatement.execute();
            System.out.println("saving data:"+insert);

            PreparedStatement preparedStatement1=connection.prepareStatement(updateQuery);
            int update=preparedStatement1.executeUpdate();
            System.out.println("updating data:"+update);

            PreparedStatement preparedStatement2=connection.prepareStatement(deleteQuery);
            int delete=preparedStatement2.executeUpdate();
            System.out.println(delete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}

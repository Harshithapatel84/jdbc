package info.xworkz.taxi.dao.impl;

import info.xworkz.taxi.dao.TaxiDAO;
import info.xworkz.taxi.dto.TaxiDetailDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaxiDaoImpl implements TaxiDAO {
    @Override
    public boolean save(TaxiDetailDTO detailDTO) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connect=null;
        String inserQuery="insert into taxi_info (driver_name,car_model,farePerKm) values (?,?,?,?)";
        try {
            connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi_info", "root", "root");
            PreparedStatement preparedStatement=connect.prepareStatement(inserQuery);
             boolean check = preparedStatement.execute();
            System.out.println("execute returned: " + check);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}

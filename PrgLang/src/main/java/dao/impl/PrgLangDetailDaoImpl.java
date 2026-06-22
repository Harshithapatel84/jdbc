package dao.impl;

import dao.PrgLangDetailDAO;
import dto.PrgLangDetailDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrgLangDetailDaoImpl implements PrgLangDetailDAO {

    @Override
    public boolean save(PrgLangDetailDTO detailDTO) {

        System.out.println("Saving programming language details : " + detailDTO);

        boolean save = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;

        String insertQuery =
                "insert into prgLang(LangName,CurtVersion,developedYear,developedBy,openSource) values(?,?,?,?,?)";

        try {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/prgLang", "root", "root");

            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, detailDTO.getLangName());
            preparedStatement.setString(2, detailDTO.getCurtVersion());
            preparedStatement.setInt(3, detailDTO.getDevelopedYear());
            preparedStatement.setString(4, detailDTO.getDevelopedBy());
            preparedStatement.setBoolean(5, detailDTO.isOpenSource());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                save = true;
                System.out.println("Data inserted successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return save;
    }
}
package com.xworkz.project1.dao.impl;

import com.xworkz.project1.dao.ActorDetailDAO;
import com.xworkz.project1.dto.ActorDetailDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActorDetailDaoImpl implements ActorDetailDAO {
    @Override
    public boolean save(ActorDetailDTO detailDTO) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String insert="insert into actor_info () values(?,?,?,?);";
        String update="update actor_info set age=35 where place='chennai'";
         String delete="delete from actor_info where movie='milana'";
        Connection connection=null;
        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_db", "root", "root");
            PreparedStatement preparedStatement=connection.prepareStatement(insert);
            preparedStatement.setString(1,detailDTO.getName());
            preparedStatement.setString(2,detailDTO.getMovie());
            preparedStatement.setInt(3,detailDTO.getAge());
            preparedStatement.setString(4,detailDTO.getPlace());
            boolean insert1=preparedStatement.execute();
            System.out.println("saving data:"+insert1);

            PreparedStatement preparedStatement1=connection.prepareStatement(update);
           int update1=preparedStatement1.executeUpdate();
            System.out.println("updating data:"+update1);

           PreparedStatement preparedStatement2=connection.prepareStatement(delete);
           int delete1=preparedStatement2.executeUpdate();
           System.out.println(delete1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}


package com.xworkz.project2.runner;

import com.xworkz.project2.dao.HotelDAO;
import com.xworkz.project2.dao.impl.HotelDaoImpl;
import com.xworkz.project2.dto.HotelDTO;

public class Runner {
    public static void main(String[] args) {
        HotelDAO hotelDAO=new HotelDaoImpl();
        HotelDTO hotelDTO=new HotelDTO();
        hotelDTO.setName("pearl");
        hotelDTO.setLocation("mysore");
        hotelDTO.setType("luxury");
        hotelDTO.setWorker(100);

        boolean insert= hotelDAO.save(hotelDTO);
        System.out.println(insert);




    }
}

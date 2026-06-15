package com.xworkz.airLine.runner;

import com.xworkz.airLine.dao.AirlineDAO;
import com.xworkz.airLine.dao.impl.AirlineDaoImpl;
import com.xworkz.airLine.dto.AirlineDTO;

public class Runner {
    public static void main(String[] args) {
        AirlineDAO airlineDAO=new AirlineDaoImpl();
        AirlineDTO airlineDTO=new AirlineDTO();
        airlineDTO.setName("singapore_airlines");
        airlineDTO.setCountry("singapore");
        airlineDTO.setType("international");
        airlineDTO.setSeating_capacity(501);

        boolean save=airlineDAO.save(airlineDTO);
        System.out.println("airline details saved:"+save);
    }

}

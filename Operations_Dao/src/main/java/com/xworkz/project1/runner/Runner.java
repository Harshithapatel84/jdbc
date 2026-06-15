package com.xworkz.project1.runner;

import com.xworkz.project1.dao.ActorDetailDAO;
import com.xworkz.project1.dao.impl.ActorDetailDaoImpl;
import com.xworkz.project1.dto.ActorDetailDTO;

public class Runner {
    public static void main(String[] args) {
        ActorDetailDAO actorDetailDAO=new ActorDetailDaoImpl();
        ActorDetailDTO actorDetailDTO=new ActorDetailDTO();
        actorDetailDTO.setName("sudeep");
        actorDetailDTO.setMovie("manikya");
        actorDetailDTO.setAge(36);
        actorDetailDTO.setPlace("karnataka");

        boolean save=actorDetailDAO.save(actorDetailDTO);
        System.out.println(save);
    }
}

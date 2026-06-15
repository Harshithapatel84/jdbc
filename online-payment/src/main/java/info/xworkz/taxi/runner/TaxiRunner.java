package info.xworkz.taxi.runner;

import info.xworkz.taxi.dao.TaxiDAO;
import info.xworkz.taxi.dao.impl.TaxiDaoImpl;
import info.xworkz.taxi.dto.TaxiDetailDTO;

public class TaxiRunner {
    public static void main(String[] args) {
        TaxiDAO taxiDAO = new TaxiDaoImpl();
        TaxiDetailDTO taxiDetailDTO = new TaxiDetailDTO();
        taxiDetailDTO.setDriverName("rohan");
        taxiDetailDTO.setCarModel("M2026");
        taxiDetailDTO.setFarePerKm(150);
    }





}

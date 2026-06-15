package info.xworkz.taxi.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxiDetailDTO {
    private String DriverName;
    private String carModel;
    private double farePerKm;
}

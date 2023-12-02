package dto;

import lombok.Getter;
import lombok.Setter;
import model.VehicleType;

@Getter
@Setter
public class ParkVehicleRequestDTO {
    private VehicleType vehicleType;
    private String regNo;
    private String color;
}

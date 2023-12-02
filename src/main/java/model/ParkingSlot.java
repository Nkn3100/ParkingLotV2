package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot extends BaseModel{
    private int number;
    private VehicleType supportedVehicleType;
    private Status status;
    private Vehicle vehicle;
}

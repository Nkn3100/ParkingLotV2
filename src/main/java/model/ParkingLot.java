package model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ParkingLot extends BaseModel{
    private String name;
    private List<ParkingFloor> parkingFloors;

}

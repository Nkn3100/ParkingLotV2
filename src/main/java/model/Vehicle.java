package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseModel{
    private VehicleType type;
    private String color;
    private String regNumber;

}

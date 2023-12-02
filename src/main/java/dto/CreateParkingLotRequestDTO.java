package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateParkingLotRequestDTO {
    private String parkingLotName;
    private int noOfFloors;
    private int noOfSlots;
}

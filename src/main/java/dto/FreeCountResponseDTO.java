package dto;

import lombok.Getter;
import lombok.Setter;
import model.VehicleType;

import java.util.HashMap;
@Getter
@Setter
public class FreeCountResponseDTO {
    HashMap<Integer, Integer> freeCount;
    VehicleType vehicleType;
}

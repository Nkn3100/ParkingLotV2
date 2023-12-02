package dto;

import lombok.Getter;
import lombok.Setter;
import model.VehicleType;

import java.util.HashMap;
import java.util.List;
@Getter
@Setter
public class FreeCountResponseDTO {
    HashMap<Integer, Integer> freeCount;
    VehicleType vehicleType;
}

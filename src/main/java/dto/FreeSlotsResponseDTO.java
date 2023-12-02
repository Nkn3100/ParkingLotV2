package dto;

import lombok.Getter;
import lombok.Setter;
import model.VehicleType;

import java.util.HashMap;
import java.util.List;
@Getter
@Setter
public class FreeSlotsResponseDTO {
    HashMap<Integer, List<Integer>> freeSlots;
    VehicleType vehicleType;
}

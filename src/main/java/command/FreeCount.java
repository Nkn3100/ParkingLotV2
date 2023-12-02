package command;

import controller.ParkingLotController;
import dto.FreeCountResponseDTO;
import model.VehicleType;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FreeCount implements Command{
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.get(1).equals("free_count");
    }

    @Override
    public void execute(String input, ParkingLotController parkingLotController) {
        List<String> words = List.of(input.split(" "));
        FreeCountResponseDTO response = parkingLotController.freeCount(VehicleType.valueOf(words.get(2)));
        for (Map.Entry<Integer, Integer> entry : response.getFreeCount().entrySet()) {
            System.out.println("No. of free slots for " + response.getVehicleType() + " on Floor " + entry.getKey() +
                    ": " + entry.getValue());
        }

    }
}

package command;

import controller.ParkingLotController;
import dto.FreeSlotsResponseDTO;
import model.Status;
import model.VehicleType;

import java.util.List;
import java.util.Map;

public class GetSlots implements Command{

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.get(1).equals("free_slots") || words.get(1).equals("occupied_slots");
    }

    @Override
    public void execute(String input, ParkingLotController parkingLotController) {
        List<String> words = List.of(input.split(" "));
        Status status = Status.FREE;
        if(words.get(1).contains("occupied_slots")){
            status = Status.OCCUPIED;
        }
        FreeSlotsResponseDTO response = parkingLotController.getSlots(VehicleType.valueOf(words.get(2)),status);
        for (Map.Entry<Integer, List<Integer>> entry : response.getFreeSlots().entrySet()) {
            StringBuilder count = new StringBuilder();
            if(!entry.getValue().isEmpty()){
                for(Integer i : entry.getValue()){
                    count.append(i).append(",");
                }
                count.deleteCharAt(count.length()-1);
            }

            if(status.equals(Status.FREE)){
                System.out.println("Free slots for " + response.getVehicleType() + " on Floor " + entry.getKey() +
                        ": " + count);
            }else{
                System.out.println("Occupied slots for " + response.getVehicleType() + " on Floor " + entry.getKey() +
                        ": " + count);
            }

        }
    }
}

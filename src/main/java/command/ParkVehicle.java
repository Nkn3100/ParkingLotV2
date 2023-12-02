package command;

import controller.ParkingLotController;
import dto.ParkVehicleRequestDTO;
import dto.ParkVehicleResponseDTO;
import model.VehicleType;

import java.util.List;

public class ParkVehicle implements Command{
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.get(0).equals("park_vehicle");
    }

    @Override
    public void execute(String input, ParkingLotController parkingLotController) {
        List<String> words = List.of(input.split(" "));
        ParkVehicleRequestDTO requestDTO = new ParkVehicleRequestDTO();
        requestDTO.setColor(words.get(3));
        requestDTO.setRegNo(words.get(2));
        requestDTO.setVehicleType(VehicleType.valueOf(words.get(1)));
        ParkVehicleResponseDTO response = parkingLotController.park(requestDTO);
        if(response == null){
            System.out.println("Parking Lot Full");
        }else{
            System.out.println("Parked vehicle. Ticket ID: " + response.getTicketId());
        }
    }
}

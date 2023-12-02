package command;

import controller.ParkingLotController;
import dto.CreateParkingLotRequestDTO;
import dto.CreateParkingLotResponseDTO;

import java.util.List;

public class CreateParkingLot implements Command{

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.get(0).equals("create_parking_lot");
    }

    @Override
    public void execute(String input, ParkingLotController parkingLotController) {
        List<String> words = List.of(input.split(" "));
        CreateParkingLotRequestDTO requestDTO = new CreateParkingLotRequestDTO();
        requestDTO.setParkingLotName(words.get(1));
        requestDTO.setNoOfFloors(Integer.parseInt(words.get(2)));
        requestDTO.setNoOfSlots(Integer.parseInt(words.get(3)));
        CreateParkingLotResponseDTO respones = parkingLotController.createParkingLot(requestDTO);
        System.out.println(respones.getResponse());

    }
}

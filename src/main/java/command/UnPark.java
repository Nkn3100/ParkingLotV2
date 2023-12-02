package command;

import controller.ParkingLotController;
import dto.UnParkResponseDTO;

import java.util.List;

public class UnPark implements Command{
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.get(0).equals("unpark_vehicle");
    }

    @Override
    public void execute(String input, ParkingLotController parkingLotController) {
        List<String> words = List.of(input.split(" "));
        String ticketNo = words.get(1);
        UnParkResponseDTO response = parkingLotController.unPark(ticketNo);
        if(response != null){
            System.out.println("Unparked vehicle with Registration Number: " + response.getRegNo()+
                    " and Color: " + response.getColor());
        }else{
            System.out.println("Invalid Ticket");
        }

    }
}

package controller;

import dto.*;
import model.*;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSlotRepository;
import service.ParkingLotService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLotController {
    private ParkingLotService parkingLotService;
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public CreateParkingLotResponseDTO createParkingLot(CreateParkingLotRequestDTO requestDTO){
        CreateParkingLotResponseDTO response = new CreateParkingLotResponseDTO();
        String responseMsg = parkingLotService.createParkingLot(requestDTO.getParkingLotName(),requestDTO.getNoOfFloors(),requestDTO.getNoOfSlots());
        response.setResponse(responseMsg);
        return response;
    }

    public ParkVehicleResponseDTO park(ParkVehicleRequestDTO requestDTO){
        ParkVehicleResponseDTO response = new ParkVehicleResponseDTO();
        Ticket ticket = parkingLotService.park(requestDTO.getRegNo(),requestDTO.getColor(),requestDTO.getVehicleType());
        if(ticket != null){
            response.setTicketId(ticket.getTicketNumber());
            return response;
        }
        return null;

    }
    public FreeCountResponseDTO freeCount(VehicleType vehicleType){
        FreeCountResponseDTO response = new FreeCountResponseDTO();
        HashMap<Integer, Integer> freeCount = parkingLotService.freeCount(vehicleType);
        response.setFreeCount(freeCount);
        response.setVehicleType(vehicleType);
        return response;
    }
    public FreeSlotsResponseDTO getSlots(VehicleType vehicleType, Status status){

        FreeSlotsResponseDTO response = new FreeSlotsResponseDTO();
        HashMap<Integer, List<Integer>> freeCount = parkingLotService.getSlots(vehicleType, status);
        response.setFreeSlots(freeCount);
        response.setVehicleType(vehicleType);
        return response;
    }
    public UnParkResponseDTO unPark(String regNo){
        UnParkResponseDTO responseDTO = new UnParkResponseDTO();
        Vehicle vehicle = parkingLotService.unPark(regNo);
        if(vehicle != null){
            responseDTO.setColor(vehicle.getColor());
            responseDTO.setRegNo(vehicle.getRegNumber());
            return responseDTO;
        }
        return null;
    }
}

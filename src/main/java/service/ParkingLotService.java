package service;

import model.*;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSlotRepository;
import repository.TicketRepository;
import strategy.ParkingFactory;
import strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSlotRepository parkingSlotRepository;
    private TicketRepository ticketRepository;

    public ParkingLotService(ParkingSlotRepository ps, ParkingFloorRepository pf, ParkingLotRepository pl,
                             TicketRepository t) {
        this.parkingSlotRepository = ps;
        this.parkingFloorRepository = pf;
        this.parkingLotRepository = pl;
        this.ticketRepository = t;
    }
    public String createParkingLot(String parkingLotName, int noOfParkingFloors, int noOfParkingSlots){
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        parkingLot.setName(parkingLotName);
        for(int i = 1; i <= noOfParkingFloors; i++){
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setFloorNumber(i);
            for(int j = 1; j <= noOfParkingSlots; j++){
                ParkingSlot parkingSlot = new ParkingSlot();
                parkingSlot.setNumber(j);
                parkingSlot.setStatus(Status.FREE);
                if(j == 1){
                    parkingSlot.setSupportedVehicleType(VehicleType.TRUCK);
                }else if(j == 2 || j ==3){
                    parkingSlot.setSupportedVehicleType(VehicleType.CAR);
                }else{
                    parkingSlot.setSupportedVehicleType(VehicleType.BIKE);
                }
                parkingSlotRepository.put(parkingSlot);
                parkingSlots.add(parkingSlot);
            }
            parkingFloor.setParkingSlots(parkingSlots);
            parkingFloors.add(parkingFloor);
            parkingFloorRepository.put(parkingFloor);
        }
        parkingLot.setParkingFloors(parkingFloors);
        parkingLotRepository.put(parkingLot);
        return "Created parking lot with "+ noOfParkingFloors +" floors and "+ noOfParkingSlots +" slots per floor";
    }

    public Ticket park(String regNo, String color, VehicleType vehicleType){
        Vehicle vehicle = new Vehicle();
        vehicle.setColor(color);
        vehicle.setType(vehicleType);
        vehicle.setRegNumber(regNo);
        // Here we can implement in future if any new way of spot allocation strategy is implementing
        ParkingStrategy parkingStrategy = ParkingFactory.getParkingStrategy();
        return parkingStrategy.park(vehicle,parkingLotRepository,ticketRepository);
    }
    public HashMap<Integer,Integer> freeCount(VehicleType vehicleType){
        HashMap<Integer,Integer> freeCount = new HashMap<>();
        ParkingLot parkingLot = parkingLotRepository.get("PR1234");
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();

        for(ParkingFloor pf : parkingFloors){
            int count = 0;
            List<ParkingSlot> parkingSlots = pf.getParkingSlots();
            for(ParkingSlot ps : parkingSlots){
                if(ps.getStatus().equals(Status.FREE) && ps.getSupportedVehicleType().equals(vehicleType)){
                    count++;
                }
            }
            freeCount.put(pf.getFloorNumber(),count);
        }
        return freeCount;
    }
    public HashMap<Integer, List<Integer>> getSlots (VehicleType vehicleType, Status status){

        HashMap<Integer,List<Integer>> slots = new HashMap<>();
        ParkingLot parkingLot = parkingLotRepository.get("PR1234");
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        for(ParkingFloor pf : parkingFloors){
            List<Integer> slotList = new ArrayList<>();
            List<ParkingSlot> parkingSlots = pf.getParkingSlots();
            for(ParkingSlot ps : parkingSlots){
                if(ps.getStatus().equals(status) && ps.getSupportedVehicleType().equals(vehicleType)){
                    slotList.add(ps.getNumber());
                }
            }
            slots.put(pf.getFloorNumber(),slotList);
        }
        return slots;
    }
    public Vehicle unPark(String regNo){
        Ticket ticket = ticketRepository.get(regNo);
        if(ticket != null) {
            ParkingFloor parkingFloor = ticket.getParkingFloor();
            ParkingSlot parkingSlot = ticket.getParkingSlot();
            parkingSlot.setStatus(Status.FREE);
            parkingSlot.setVehicle(null);
            parkingSlotRepository.put(parkingSlot);
            parkingFloorRepository.put(parkingFloor);
            return ticket.getVehicle();
        }
        return null;
    }
}


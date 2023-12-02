package service;

import models.*;
import repository.GateRepository;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;

public class InitialisationService {
    private GateRepository gateRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public InitialisationService(GateRepository gateRepository, ParkingFloorRepository parkingFloorRepository, ParkingLotRepository parkingLotRepository, ParkingSpotRepository parkingSpotRepository) {
        this.gateRepository = gateRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    /***
     *  This will create a parking lot with 10 floors, and each floor having 10 spots
     * @return ParkingLot object
     */

    public ParkingLot initialise(){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setStatus(Status.ACTIVE);
        parkingLot.setAddress("Road A, City C, State S");
        parkingLot.setCapacity(100);

        Gate entryGate = new Gate();
        entryGate.setId(1);
        entryGate.setOperator("Subramani");
        entryGate.setGateNumber(1);
        entryGate.setFloorNumber(1);
        entryGate.setGateType(GateType.ENTRY);
        entryGate.setStatus(Status.ACTIVE);
        entryGate.setParkingLotId(1);

        Gate exitGate = new Gate();
        exitGate.setId(2);
        exitGate.setOperator("Sridhar");
        exitGate.setGateNumber(2);
        exitGate.setFloorNumber(1);
        exitGate.setGateType(GateType.EXIT);
        exitGate.setStatus(Status.ACTIVE);
        exitGate.setParkingLotId(1);

        parkingLot.setGates(List.of(exitGate,entryGate));
        gateRepository.put(entryGate);
        gateRepository.put(exitGate);

        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for (int i=1; i <= 10; i++){
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(100 + i);
            parkingFloor.setStatus(Status.ACTIVE);
            parkingFloor.setFloorNumber(i);
            for(int j = 1; j <=10; j++){
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setId(1000+j);
                parkingSpot.setNumber(i * 100 + j);
                if(j%2 == 0){
                    parkingSpot.setSupportedVehicleType(VehicleType.Two_Wheeler);
                }else{
                    parkingSpot.setSupportedVehicleType(VehicleType.Four_Wheeler);
                }
                parkingSpot.setStatus(Status.AVAILABLE);
                parkingSpots.add(parkingSpot);
                parkingSpotRepository.put(parkingSpot);

            }
            parkingFloor.setParkingSpots(parkingSpots);
            parkingFloorRepository.put(parkingFloor);
            parkingFloors.add(parkingFloor);
        }
        parkingLot.setParkingFloors(parkingFloors);
        parkingLotRepository.put(parkingLot);
        return parkingLot;
    }
}

package repository;

import exception.ParkingFloorNotFoundException;
import model.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository{
    private Map<Integer, ParkingFloor> parkingFloorMap;

    public ParkingFloorRepository() {
        this.parkingFloorMap = new HashMap<>();
    }
    public ParkingFloor get(int parkingFloorId){
        if(parkingFloorMap.containsKey(parkingFloorId)){
            return parkingFloorMap.get(parkingFloorId);
        }else{
            throw new ParkingFloorNotFoundException("Parking floor not found for : " + parkingFloorId);
        }
    }
    public void put(ParkingFloor parkingFloor){
        parkingFloorMap.put(parkingFloor.getFloorNumber(), parkingFloor);
    }
}

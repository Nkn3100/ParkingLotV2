package repository;

import exception.ParkingSlotNotFoundException;
import model.ParkingSlot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSlotRepository {
    private Map<Integer, ParkingSlot> parkingSlotMap;

    public ParkingSlotRepository() {
        this.parkingSlotMap = new HashMap<>();

    }
    public ParkingSlot get(int parkingSlotId){
        if(parkingSlotMap.containsKey(parkingSlotId)){
            return parkingSlotMap.get(parkingSlotId);
        }else{
            throw new ParkingSlotNotFoundException("Parking slot not found for : " + parkingSlotId);
        }
    }
    public void put(ParkingSlot parkingSlot){
        parkingSlotMap.put(parkingSlot.getNumber(), parkingSlot);
    }
}

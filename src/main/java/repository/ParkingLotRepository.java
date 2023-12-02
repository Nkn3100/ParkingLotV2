package repository;

import exception.ParkingLotNotFoundException;
import model.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<String, ParkingLot> parkingLotMap;
    public ParkingLotRepository(){
        this.parkingLotMap = new HashMap<>();
    }
    public ParkingLot get(String parkingLotName){
        if(parkingLotMap.containsKey(parkingLotName)){
            return parkingLotMap.get(parkingLotName);
        }else{
            throw new ParkingLotNotFoundException("Parking lot not found for : " + parkingLotName);
        }
    }
    public void put(ParkingLot parkingLot){
        parkingLotMap.put(parkingLot.getName(), parkingLot);
    }
}

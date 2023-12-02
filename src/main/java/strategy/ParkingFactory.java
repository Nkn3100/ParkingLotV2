package strategy;

import repository.ParkingLotRepository;

public class ParkingFactory {
    public static ParkingStrategy getParkingStrategy(){
        return new DefaultParkingStrategy();

    }
}

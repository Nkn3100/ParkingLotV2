package strategy;

import repository.ParkingLotRepository;

public class ParkingFactory {
    public static ParkingStrategy getParkingStrategy(ParkingLotRepository parkingLotRepository){
        return new DefaultParkingStrategy();

    }
}

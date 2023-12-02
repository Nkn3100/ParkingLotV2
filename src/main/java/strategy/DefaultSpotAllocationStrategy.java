package strategy;

import model.ParkingLot;
import model.ParkingSlot;
import model.VehicleType;
import repository.ParkingLotRepository;

public class DefaultSpotAllocationStrategy implements SpotAllocationStrategy{
    private ParkingLotRepository parkingLotRepository;
    @Override
    public ParkingSlot getSlot(VehicleType vehicleType,ParkingLot lot) {
        ParkingLot parkingLot = parkingLotRepository.get(lot.getName());

        return null;
    }
}

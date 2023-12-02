package strategy;

import model.ParkingLot;
import model.ParkingSlot;
import model.VehicleType;

public interface SpotAllocationStrategy {
    ParkingSlot getSlot(VehicleType vehicleType, ParkingLot parkingLot);
}

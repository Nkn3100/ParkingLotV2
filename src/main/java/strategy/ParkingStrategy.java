package strategy;

import model.ParkingLot;
import model.Ticket;
import model.Vehicle;
import model.VehicleType;
import repository.ParkingLotRepository;
import repository.TicketRepository;

public interface ParkingStrategy {
    Ticket park(Vehicle vehicle, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository);
}

package strategy;

import model.Ticket;
import model.Vehicle;
import repository.ParkingLotRepository;
import repository.TicketRepository;

public interface ParkingStrategy {
    Ticket park(Vehicle vehicle, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository);
}

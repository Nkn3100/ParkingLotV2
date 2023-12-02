package strategy;

import model.*;
import repository.ParkingLotRepository;
import repository.TicketRepository;

import java.util.List;

public class DefaultParkingStrategy implements ParkingStrategy {
    @Override
    public Ticket park(Vehicle vehicle, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        ParkingLot parkingLot = parkingLotRepository.get("PR1234");
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        Ticket ticket = new Ticket();
        for(ParkingFloor pf : parkingFloors){
            List<ParkingSlot> parkingSlots = pf.getParkingSlots();
            for(ParkingSlot ps: parkingSlots){
                if(ps.getStatus() == Status.FREE && ps.getSupportedVehicleType() == vehicle.getType()){
                    ps.setVehicle(vehicle);
                    ps.setStatus(Status.OCCUPIED);
                    ticket.setParkingSlot(ps);
                    ticket.setVehicle(vehicle);
                    ticket.setParkingFloor(pf);
                    String ticketNo = "PR1234_" + pf.getFloorNumber() +"_" + ps.getNumber();
                    ticket.setTicketNumber(ticketNo);
                    ticketRepository.put(ticket);
                    return ticket;
                }
            }
        }
        return null;
    }
}

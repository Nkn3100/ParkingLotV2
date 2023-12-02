package repository;

import exception.TicketNotFoundException;
import model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private
    Map<String, Ticket> ticketMap;

    public TicketRepository() {
        this.ticketMap = new HashMap<>();

    }
    public Ticket get(String TicketNumber){
        if(ticketMap.containsKey(TicketNumber)){
            return ticketMap.get(TicketNumber);
        }else{
            throw new TicketNotFoundException("Ticket not found for : " + TicketNumber);
        }

    }
    public void put(Ticket Ticket){
        ticketMap.put(Ticket.getTicketNumber(), Ticket);

    }
}

package controller;

import dto.IssueTicketRequestDTO;
import dto.IssueTicketResponseDTO;
import exception.InvalidRequestDataException;

public class TicketController {

    public IssueTicketResponseDTO getTicket(IssueTicketRequestDTO ticketRequestDTO){
        IssueTicketResponseDTO response = new IssueTicketResponseDTO();

        try{
            if(ticketRequestDTO.getVehicleType() == null || ticketRequestDTO.getVehicleNumber() == null){
                throw new InvalidRequestDataException("Ticket generation request is invalid");
            }
        }catch(Exception e){

        }
        return null;
    }
}

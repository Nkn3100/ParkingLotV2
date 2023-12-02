package dto;

import lombok.Getter;
import lombok.Setter;
import model.Ticket;
@Getter
@Setter
public class IssueTicketResponseDTO {
    private String responseStatus;
    private String failureReason;
    private Ticket ticket;
}

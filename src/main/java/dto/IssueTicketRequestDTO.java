package dto;

import lombok.Getter;
import lombok.Setter;
import model.VehicleType;
@Getter
@Setter
public class IssueTicketRequestDTO {
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String vehicleColor;
}

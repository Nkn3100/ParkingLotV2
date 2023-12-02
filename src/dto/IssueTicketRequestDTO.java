package dto;

import models.Vehicle;
import models.VehicleType;

public class IssueTicketRequestDTO {
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String vehicleColor;
    private Integer gateId;
    private String vehicleMake;

    public Integer getGateId() {
        return gateId;
    }

    public void setGateId(Integer gateId) {
        this.gateId = gateId;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public IssueTicketRequestDTO() {
    }

    public IssueTicketRequestDTO(VehicleType vehicleType, String vehicleNumber, String vehicleColor, Integer gateId, String vehicleMake) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.vehicleColor = vehicleColor;
        this.gateId = gateId;
        this.vehicleMake = vehicleMake;
    }
}

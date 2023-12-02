package command;

import controller.ParkingLotController;

public interface Command {
    public boolean matches(String input);
    public void execute(String input, ParkingLotController parkingLotController);
}

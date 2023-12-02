package command;

import controller.ParkingLotController;

public interface Command {
    boolean matches(String input);
    void execute(String input, ParkingLotController parkingLotController);
}

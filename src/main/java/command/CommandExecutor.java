package command;

import controller.ParkingLotController;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();
    public void addCommand(Command command){
        commands.add(command);
    }
    public void removeCommand(Command command){
        commands.remove(command);
    }
    public void execute(String input, ParkingLotController parkingLotController) throws Exception {
        boolean commandCheck = false;
        for(Command command : commands){
            if(command.matches(input)){
                commandCheck = true;
                command.execute(input,parkingLotController);
                break;
            }

        }
        if(!commandCheck){
            throw new Exception("The requested command is not correct.");
        }
    }
}

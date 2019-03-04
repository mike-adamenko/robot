package com.adamenko.springbootreact.model.command;

public class CommandFactory {

    public static Command getCommand(String commandString) {

        String[] commandStr = commandString.split(" ");
        switch (CommandType.valueOf(commandStr[0])) {
            case POSITION:
                String[] argsP = {commandStr[1], commandStr[2]};
                return new PositionCommand(argsP);
            case LEFT:
                return new LeftCommand();
            case RIGHT:
                return new RightCommand();
            case FORWARD:
                String[] argsF = {commandStr[1]};
                return new ForwardCommand(argsF);
            case TURNAROUND:
                return new TurnAroundCommand();
            case WAIT:
                return new WaitCommand();
        }
        return null;
    }
}

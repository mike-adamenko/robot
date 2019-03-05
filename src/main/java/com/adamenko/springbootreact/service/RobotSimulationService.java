package com.adamenko.springbootreact.service;

import com.adamenko.springbootreact.model.CommandHolder;
import com.adamenko.springbootreact.model.Robot;
import com.adamenko.springbootreact.model.command.Command;
import com.adamenko.springbootreact.model.command.CommandFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RobotSimulationService {

    private final Logger log = LoggerFactory.getLogger(RobotSimulationService.class);

    public Robot process(String script) {
        CommandHolder commandHolder = parseScript(script);
        Robot robot = new Robot();

        for (String commandString : commandHolder.getCommands()) {
            Command command = CommandFactory.getCommand(commandString);
            if (command != null) {
                command.execute(robot);
            } else {
                log.debug("Wrong command: " + commandString);
            }
        }
        return robot;
    }

    /**
     * Parses script like below
     * <p>
     * <pre>
     * POSITION 1 3 EAST //sets the initial position for the robot as x, y.
     * FORWARD 3 //lets the robot do 3 steps forward
     * WAIT //lets the robot do nothing
     * TURNAROUND //lets the robot turn around
     * FORWARD 1 //lets the robot do 1 step forward
     * RIGHT //lets the robot turn right
     * FORWARD 2 //lets the robot do 2 steps forward
     * </pre>
     *
     * @param script
     * @return
     */
    private CommandHolder parseScript(String script) {
        CommandHolder commandHolder = new CommandHolder();
        Arrays.stream(script.split("\n")).map(s ->
        {
            s = s.indexOf('/') != -1 ? s.substring(0, s.indexOf('/')) : s;
            return s;
        }).forEach(s -> commandHolder.addCommand(s));

        return commandHolder;
    }

}

package com.idealo.robot.model.command;

import com.idealo.robot.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitCommand extends Command {
    private final Logger log = LoggerFactory.getLogger(WaitCommand.class);

    @Override
    public void execute(Robot robot) {
        if (!robot.isOnTable()) {
            log.debug("Wait command is ignored");
        }
        log.debug("The robot is waiting");
    }
}

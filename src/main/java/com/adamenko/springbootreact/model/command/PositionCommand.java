package com.adamenko.springbootreact.model.command;

import com.adamenko.springbootreact.model.Direction;
import com.adamenko.springbootreact.model.Robot;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PositionCommand extends Command {
    private final Logger log = LoggerFactory.getLogger(PositionCommand.class);

    public PositionCommand(String[] args) {
        super(args);
    }

    @Override
    public void execute(Robot robot) {
        Integer initialX = Integer.parseInt(getArgs()[0].trim());
        Integer initialY = Integer.parseInt(getArgs()[1].trim());

        if (initialX <= Robot.MAX_POSITION && initialX >= Robot.MIN_POSITION
                && initialY <= Robot.MAX_POSITION && initialY >= Robot.MIN_POSITION) {
            robot.setX(initialX);
            robot.setY(initialY);
            robot.setDirection(Direction.valueOf(getArgs()[2].trim()));
            log.debug("Robot is placed at " + robot.getCurrentStatus());
        } else {
            log.debug("Position command is ignored");
        }
    }
}

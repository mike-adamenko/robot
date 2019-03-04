package com.adamenko.springbootreact.model.command;

import com.adamenko.springbootreact.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForwardCommand extends Command {
    private final Logger log = LoggerFactory.getLogger(ForwardCommand.class);

    public ForwardCommand(String[] args) {
        super(args);
    }

    @Override
    public void execute(Robot robot) {
        if (!robot.isOnTable()) {
            log.debug("Forward command is ignored");
        } else {
            int steps = Integer.parseInt(getArgs()[0]);
            switch (robot.getDirection()) {
                case NORTH:
                    if (robot.getY() < Robot.MAX_POSITION) {
                        robot.decreaseY(steps);
                        log.debug("The robot is moving");

                    } else {
                        log.debug("Forward command ignored");
                    }
                    break;

                case SOUTH:
                    if (robot.getY() >= Robot.MIN_POSITION && robot.getY()< Robot.MAX_POSITION) {
                        robot.increaseY(steps);
                        log.debug("The robot is moving");
                    } else {
                        log.debug("Forward command ignored");
                    }
                    break;

                case EAST:
                    if (robot.getX() < Robot.MAX_POSITION) {
                        robot.increaseX(steps);
                        log.debug("The robot is moving");
                    } else {
                        log.debug("Forward command ignored");
                    }
                    break;

                case WEST:
                    if (robot.getX() > Robot.MIN_POSITION) {
                        robot.decreaseX(steps);
                        log.debug("The robot is moving");
                    } else {
                        log.debug("Forward command ignored");
                    }
                    break;
            }

        }
    }
}

package com.idealo.robot.command;

import com.idealo.robot.model.Direction;
import com.idealo.robot.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class TurnAroundCommand extends Command {
    private final Logger log = LoggerFactory.getLogger(TurnAroundCommand.class);

    @Override
    public void execute(Robot robot) {
        if (!robot.isOnTable()) {
            log.debug("TurnAround command ignored");
        } else {
            switch (robot.getDirection()) {
                case NORTH:
                    robot.setDirection(Direction.SOUTH);
                    break;
                case SOUTH:
                    robot.setDirection(Direction.NORTH);
                    break;
                case EAST:
                    robot.setDirection(Direction.WEST);
                    break;
                case WEST:
                    robot.setDirection(Direction.EAST);
                    break;
            }
            log.debug("The robot is turned around on  " + robot.getDirection());

        }
    }
}

package com.idealo.robot.command;


import com.idealo.robot.model.Robot;

/**
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public abstract class Command {

    private String[] args;

    public Command() {}

    public Command(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public abstract void execute(Robot robot);
}

package com.idealo.robot.command;


import com.idealo.robot.model.Robot;

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

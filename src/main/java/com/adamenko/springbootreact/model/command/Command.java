package com.adamenko.springbootreact.model.command;


import com.adamenko.springbootreact.model.Robot;

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

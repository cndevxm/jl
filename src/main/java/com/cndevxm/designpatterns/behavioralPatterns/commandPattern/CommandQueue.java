package com.cndevxm.designpatterns.behavioralPatterns.commandPattern;

import java.util.ArrayList;
import java.util.List;

public class CommandQueue {

    private List<Command> commands = new ArrayList<Command>() {{
        add(new InsertCommand());
        add(new UpdateCommand());
        add(new DeleteCommand());
        add(new QueryCommand());
        add(new InsertCommand());
        add(new UpdateCommand());
    }};

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}

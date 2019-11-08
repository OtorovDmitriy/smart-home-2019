package ru.sbt.mipt.oop.remote.control.commands;

import ru.sbt.mipt.oop.remote.control.CommandList;
import ru.sbt.mipt.oop.remote.control.RemoteCommand;

public class TurnOnHallLightCommand implements RemoteCommand {
    private CommandList commandList;

    public TurnOnHallLightCommand(CommandList commandList) {
        this.commandList = commandList;
    }

    @Override
    public void execute() {
        commandList.turnOnHallLight();
    }
}

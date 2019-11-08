package ru.sbt.mipt.oop.remote.control.commands;

import ru.sbt.mipt.oop.remote.control.CommandList;
import ru.sbt.mipt.oop.remote.control.RemoteCommand;

public class TurnOnAlarmCommand implements RemoteCommand {
    private CommandList commandList;

    public TurnOnAlarmCommand(CommandList commandList) {
        this.commandList = commandList;
    }

    @Override
    public void execute() {
        commandList.turnOnAlarm();
    }
}

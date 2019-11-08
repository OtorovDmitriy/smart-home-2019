package ru.sbt.mipt.oop.remote.control.commands;

import ru.sbt.mipt.oop.remote.control.CommandList;
import ru.sbt.mipt.oop.remote.control.RemoteCommand;

public class TurnOnAlertAlarmCommand implements RemoteCommand {
    private CommandList commandList;

    public TurnOnAlertAlarmCommand(CommandList commandList) {
        this.commandList = commandList;
    }

    @Override
    public void execute() {
        commandList.turnOnAlertAlarm();
    }
}

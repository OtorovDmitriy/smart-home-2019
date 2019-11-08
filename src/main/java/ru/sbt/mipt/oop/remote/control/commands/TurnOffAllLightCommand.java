package ru.sbt.mipt.oop.remote.control.commands;

import ru.sbt.mipt.oop.remote.control.CommandList;
import ru.sbt.mipt.oop.remote.control.CommandListConstructor;
import ru.sbt.mipt.oop.remote.control.RemoteCommand;

public class TurnOffAllLightCommand extends CommandListConstructor implements RemoteCommand {
    private CommandList commandList;

    public TurnOffAllLightCommand(CommandList commandList) {
        super(commandList);
    }

    @Override
    public void execute() {
        commandList.turnOffAllLight();
    }
}

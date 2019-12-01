package ru.sbt.mipt.oop.remote.control;

import ru.sbt.mipt.oop.remote.control.commands.Command;

import java.util.HashMap;

public class RemoteControlRealisation implements RemoteControl {
    private HashMap<String, Command> remoteControlCommands;

    public RemoteControlRealisation() {
        this.remoteControlCommands = new HashMap<>();
    }

    public void addRemoteControlCommands(String buttonType, Command command) {
        remoteControlCommands.put(buttonType, command);
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        if (remoteControlCommands.containsKey(buttonCode)) {
            remoteControlCommands.get(buttonCode).execute();
        }
    }
}
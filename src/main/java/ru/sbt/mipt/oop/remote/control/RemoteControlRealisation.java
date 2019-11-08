package ru.sbt.mipt.oop.remote.control;

import rc.RemoteControl;
import rc.RemoteControlRegistry;

import java.util.HashMap;

public class RemoteControlRealisation implements RemoteControl {
    private HashMap<String, RemoteCommand> buttonsTypeAndCode;

    RemoteControlRealisation(RemoteControlRegistry remoteControlRegistry) {
        this.buttonsTypeAndCode = new HashMap<>();
    }

    public void putRemoteCommand(String buttonType, RemoteCommand remoteCommand) {
        buttonsTypeAndCode.put(buttonType, remoteCommand);
    }

    @Override
    public void onButtonPressed(String buttonType, String rcId) {
        RemoteCommand command = buttonsTypeAndCode.get(buttonType);
        command.execute();
    }
}
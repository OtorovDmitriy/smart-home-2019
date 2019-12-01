package ru.sbt.mipt.oop.remote.control.commands;

import ru.sbt.mipt.oop.alarm.Alarm;

public class ActivateAlert implements Command {
    private Alarm alarm;

    public ActivateAlert(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.enableAlert();
    }
}

package ru.sbt.mipt.oop.remote.control.commands;

import ru.sbt.mipt.oop.alarm.Alarm;

public class ActivateAlarm implements Command {
    private Alarm alarm;

    public ActivateAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.activate();
    }
}

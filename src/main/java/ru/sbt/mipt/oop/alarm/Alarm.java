package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.SmartHome;

public abstract class Alarm {
    SmartHome smartHome;

    Alarm(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public abstract String activate();
    public abstract String deactivate();
    public abstract String alertAlarm();
}

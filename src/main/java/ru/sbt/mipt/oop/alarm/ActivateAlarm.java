package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.SmartHome;

public class ActivateAlarm extends Alarm {

    ActivateAlarm(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    public String activate() {
        return null;
    }

    @Override
    public String deactivate() {
        return null;
    }

    @Override
    public String alertAlarm() {
        return null;
    }
}

package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.SmartHome;

public class AlertAlarm extends Alarm {
    AlertAlarm(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    public void activate() {
        // System.out.println("Alarm!!!");;
    }
}

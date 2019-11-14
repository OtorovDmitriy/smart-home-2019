package ru.sbt.mipt.oop.alarm;

public class AlertAlarm implements AlarmInterface {
    @Override
    public void activate(Alarm alarm) {
        System.out.println("Alert...Alert...Alert...");
    }
}

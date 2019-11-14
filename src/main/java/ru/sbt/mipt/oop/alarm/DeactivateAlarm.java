package ru.sbt.mipt.oop.alarm;

public class DeactivateAlarm implements AlarmInterface {
    @Override
    public void activate(Alarm alarm) {
        alarm.setCode("");
        System.out.println("Alarm Deactivate!");
    }
}

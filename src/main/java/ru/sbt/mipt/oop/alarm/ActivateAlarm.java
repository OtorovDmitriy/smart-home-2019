package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.sensor.event.SensorEventType;

public class ActivateAlarm implements AlarmInterface {
    @Override
    public void activate(Alarm alarm) {
        alarm.setCode(SensorEventType.ALARM_ACTIVATE.getCode());
        System.out.println("Alarm activate!");
    }
}

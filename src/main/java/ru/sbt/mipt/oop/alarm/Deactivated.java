package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.sensor.event.SensorEventType;

public class Deactivated implements AlarmState {
    private Alarm alarm;

    public Deactivated(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate() {
        String tempCode = SensorEventType.ALARM_ACTIVATE.getCode();
        if (!tempCode.isEmpty()) {
            alarm.setCode(tempCode);
            alarm.setAlarmState(new Activated(alarm));
            System.out.println("Alarm activated.");
        }
    }

    @Override
    public void deactivate() {
        System.out.println("Alarm is not activated.");
    }

    @Override
    public void enableAlert() {
        alarm.setAlarmState(new Alert(alarm));
        alarm.enableAlert();
    }
}

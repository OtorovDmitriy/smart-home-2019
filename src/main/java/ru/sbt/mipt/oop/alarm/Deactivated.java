package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.sensor.event.SensorEventType;

public class Deactivated implements State {
    private Alarm alarm;

    @Override
    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate() {
        String tempCode = SensorEventType.ALARM_ACTIVATE.getCode();
        if (!tempCode.isEmpty()) {
            alarm.setCode(tempCode);
            alarm.setState(new Activated());
            System.out.println("Alarm activated.");
        }
    }

    @Override
    public void deactivate() {
        System.out.println("Alarm is not activated.");
    }

    @Override
    public void enableAlert() {
        alarm.setState(new Alert());
        alarm.enableAlert();
    }
}

package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.sensor.event.SensorEventType;

public class Activated implements State {
    private Alarm alarm;

    @Override
    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate() {
        this.enableAlert();
    }

    @Override
    public void deactivate() {
        if (alarm.getAlarmState()) {
            String tempCode = SensorEventType.ALARM_DEACTIVATE.getCode();
            if (alarm.checkCode(tempCode)) {
                alarm.setCode("");
                alarm.setState(new Deactivated());
                System.out.println("Alarm deactivated.");
            } else {
                this.enableAlert();
            }
        } else {
            System.out.println("Alarm not activated.");
        }
    }

    @Override
    public void enableAlert() {
        alarm.setState(new Alert());
        alarm.enableAlert();
    }
}
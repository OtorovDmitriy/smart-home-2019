package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.sensor.event.SensorEventType;

public class Activated implements AlarmState {
    private Alarm alarm;

    public Activated(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate() {
        this.enableAlert();
    }

    @Override
    public void deactivate() {
        if (alarm.getAlarmState() instanceof Activated) {
            String tempCode = SensorEventType.ALARM_DEACTIVATE.getCode();
            if (alarm.checkCode(tempCode)) {
                alarm.setCode("");
                alarm.setAlarmState(new Deactivated(alarm));
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
        alarm.setAlarmState(new Alert(alarm));
        alarm.enableAlert();
    }
}
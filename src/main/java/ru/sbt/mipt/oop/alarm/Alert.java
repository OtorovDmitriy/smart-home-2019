package ru.sbt.mipt.oop.alarm;

public class Alert implements AlarmState {
    private Alarm alarm;

    public Alert(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void enableAlert() {
        if (!alarm.checkCode("")) {
            alarm.setAlarmState(new Activated(alarm));
        } else {
            alarm.setAlarmState(new Deactivated(alarm));
        }
    }
}

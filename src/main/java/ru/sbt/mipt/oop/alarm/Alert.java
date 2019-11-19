package ru.sbt.mipt.oop.alarm;

public class Alert implements State {
    private Alarm alarm;

    @Override
    public void setAlarm(Alarm alarm) {
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
        System.out.println("Sending SMS...");
        if (alarm.getAlarmState()) {
            alarm.setState(new Activated());
        } else {
            alarm.setState(new Deactivated());
        }
    }
}

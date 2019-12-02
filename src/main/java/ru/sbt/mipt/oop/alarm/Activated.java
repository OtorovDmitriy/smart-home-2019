package ru.sbt.mipt.oop.alarm;

public class Activated implements AlarmState {
    private Alarm alarm;

    public Activated(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {
        this.enableAlert();
    }

    @Override
    public void deactivate(String code) {
        if (alarm.checkCode(code)) {
            alarm.setCode("");
            alarm.setAlarmState(new Deactivated(alarm));
            System.out.println("Alarm deactivated.");
        } else {
            this.enableAlert();
        }
    }

    @Override
    public void enableAlert() {
        alarm.setAlarmState(new Alert(alarm));
        alarm.enableAlert();
    }
}
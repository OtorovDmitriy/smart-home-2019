package ru.sbt.mipt.oop.alarm;

public class Deactivated implements AlarmState {
    private Alarm alarm;

    public Deactivated(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {
        alarm.setCode(code);
        alarm.setAlarmState(new Activated(alarm));
        System.out.println("Alarm activated.");
    }

    @Override
    public void deactivate(String code) {
        System.out.println("Alarm is not activated.");
    }

    @Override
    public void enableAlert() {
        alarm.setAlarmState(new Alert(alarm));
        alarm.enableAlert();
    }
}

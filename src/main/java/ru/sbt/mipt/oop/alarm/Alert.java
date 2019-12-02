package ru.sbt.mipt.oop.alarm;

public class Alert implements AlarmState {
    private Alarm alarm;

    public Alert(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {

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
    public void enableAlert() {}
}

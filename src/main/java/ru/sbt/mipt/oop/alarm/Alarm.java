package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.event.processor.Action;
import ru.sbt.mipt.oop.event.processor.Actionable;

public class Alarm implements Actionable {
    private AlarmState alarmState;
    private String code = "";

    public Alarm() {
        this.alarmState = new Deactivated(this);
    }

    void setAlarmState(AlarmState alarmState) {
        this.alarmState = alarmState;
    }

    public AlarmState getAlarmState() {
        return alarmState;
    }

    void setCode(String code) {
        this.code = code;
    }

    boolean checkCode(String code) {
        return this.code.equals(code);
    }

    public void activate(String code) {
        alarmState.activate(code);
    }

    public void deactivate(String code) {
        alarmState.deactivate(code);
    }

    public void enableAlert() {
        alarmState.enableAlert();
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}

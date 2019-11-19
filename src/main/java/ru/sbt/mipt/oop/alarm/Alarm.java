package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.event.processor.Action;
import ru.sbt.mipt.oop.event.processor.Actionable;

public class Alarm implements Actionable {
    private State state;
    private Boolean alarmState = false;
    private String code = "";

    public Alarm() {
        this.state = new Deactivated();
        state.setAlarm(this);
    }

    void setState(State state) {
        this.state = state;
        state.setAlarm(this);
    }

    void setCode(String code) {
        this.alarmState = !this.alarmState;
        this.code = code;
    }

    boolean checkCode(String code) {
        return this.code.equals(code);
    }

    boolean getAlarmState() {
        return alarmState;
    }

    public void activate() {
        state.activate();
    }

    public void deactivate() {
        state.deactivate();
    }

    public void enableAlert() {
        state.enableAlert();
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}

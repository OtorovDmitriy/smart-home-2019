package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.event.processor.Action;
import ru.sbt.mipt.oop.event.processor.Actionable;

public class Alarm implements Actionable {
    private AlarmInterface state;
    private Boolean alarmState = false;
    private String code = "";

    public void setState(AlarmInterface state) {
        this.state = state;
    }

    public void setCode(String code) {
        this.alarmState = !this.alarmState;
        this.code = code;
    }

    public boolean checkCode(String code) {
        return this.code.equals(code);
    }

    public boolean getAlarmState() {
        return alarmState;
    }

    public void activate() {
        state.activate(this);
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}

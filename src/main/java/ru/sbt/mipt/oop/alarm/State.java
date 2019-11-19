package ru.sbt.mipt.oop.alarm;

public interface State {
    void setAlarm(Alarm alarm);
    void activate();
    void deactivate();
    void enableAlert();
}

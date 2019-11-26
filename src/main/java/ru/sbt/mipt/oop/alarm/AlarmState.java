package ru.sbt.mipt.oop.alarm;

public interface AlarmState {
    void activate();
    void deactivate();
    void enableAlert();
}

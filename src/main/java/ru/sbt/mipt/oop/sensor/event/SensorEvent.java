package ru.sbt.mipt.oop.sensor.event;

public interface SensorEvent {
    SensorEventType getType();
    String getObjectId();
}

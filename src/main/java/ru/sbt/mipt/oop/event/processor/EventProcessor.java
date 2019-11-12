package ru.sbt.mipt.oop.event.processor;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;

public interface EventProcessor {
    void Process(SmartHome smartHome, SensorEvent sensorEvent);
}

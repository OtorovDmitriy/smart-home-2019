package ru.sbt.mipt.oop.event_processor;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor_event.SensorEvent;

public interface EventProcessor {
    void Process(SmartHome smartHome, SensorEvent sensorEvent);
}

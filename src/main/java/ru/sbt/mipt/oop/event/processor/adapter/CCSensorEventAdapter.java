package ru.sbt.mipt.oop.event.processor.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;

public interface CCSensorEventAdapter {
    SensorEvent convert(CCSensorEvent ccSensorEvent);
}

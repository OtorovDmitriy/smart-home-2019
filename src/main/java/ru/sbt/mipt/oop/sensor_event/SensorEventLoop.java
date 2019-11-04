package ru.sbt.mipt.oop.sensor_event;

import java.util.ArrayList;
import java.util.List;

public class SensorEventLoop {

    public List<SensorEvent> getSensorEventList() {
        List<SensorEvent> sensorEventsArray = new ArrayList<>();
        SensorEvent currentEvent = new SensorEventGenerator().getNextSensorEvent();

        while (currentEvent != null) {
            sensorEventsArray.add(currentEvent);
            currentEvent = new SensorEventGenerator().getNextSensorEvent();
        }

        return sensorEventsArray;
    }
}
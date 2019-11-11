package ru.sbt.mipt.oop.sensor.event;

import ru.sbt.mipt.oop.SmartHome;

import java.util.ArrayList;

public class SensorEventLoop {

    private ArrayList<SensorEventElement> sensorEventArrayList = new ArrayList<>();

    public void addItem(SensorEventElement sensorEventElement) {
        sensorEventArrayList.add(sensorEventElement);
    }

    public void cleanList() {
        sensorEventArrayList = new ArrayList<>();
    }

    public void handleEvents(SmartHome smartHome) {
        for (SensorEventElement sensorEvent : sensorEventArrayList) {
            sensorEvent.switchElementState(smartHome);
        }
    }
}

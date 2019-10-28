package ru.sbt.mipt.oop.sensor.event;

import ru.sbt.mipt.oop.SmartHome;

import java.util.ArrayList;

public class SensorEventLoop {

    private ArrayList<SensorEventElement> sensorEventArrayList;

    public SensorEventLoop(SensorEventType type, String objectId) {
        sensorEventArrayList = new ArrayList<>();
        sensorEventArrayList.add(new SensorEventDoor(type, objectId));
        sensorEventArrayList.add(new SensorEventLight(type, objectId));
    }

    public void createSensorEventLoop(SensorEvent event, SmartHome smartHome) {
        SensorEvent currentEvent = event;
        SensorEventGenerator sensorEventGenerator = new SensorEventGenerator();

        if (currentEvent.getType() == null) {
            currentEvent = sensorEventGenerator.getNextSensorEvent();
            createSensorEventLoop(currentEvent, smartHome);
            // or print error message and return nothing
        }

        while (currentEvent != null) {
            System.out.println("Got event: " + currentEvent);

            for (SensorEventElement sensorEvent : sensorEventArrayList) {
                sensorEvent.switchElementState(smartHome);
            }

            currentEvent = sensorEventGenerator.getNextSensorEvent();
        }
    }
}

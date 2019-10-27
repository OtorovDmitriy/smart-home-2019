package ru.sbt.mipt.oop.sensor.event;

import ru.sbt.mipt.oop.SmartHome;

public class SensorEventLoop {

    public void createSensorEventLoop(SensorEvent event, SmartHome smartHome) {
        SensorEvent currentEvent = event;
        SensorEventGenerator sensorEventGenerator = new SensorEventGenerator();

        while (currentEvent != null) {
            SensorEventType eventType = currentEvent.getType();
            String eventObjectId = currentEvent.getObjectId();

            System.out.println("Got event: " + currentEvent);
            SensorEventLoopType.valueOf(eventType.toString()).callRoomElement(smartHome, eventType, eventObjectId);
            currentEvent = sensorEventGenerator.getNextSensorEvent();
        }
    }
}
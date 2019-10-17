package ru.sbt.mipt.oop.sensor_event;

import ru.sbt.mipt.oop.SmartHome;

public class SensorEventLoop {

    public void changeStateOfRoomElement(SensorEvent event, SmartHome smartHome) {
        SensorEvent currentEvent = event;

        while (currentEvent != null) {
            SensorEventType eventType = currentEvent.getType();
            String eventObjectId = currentEvent.getObjectId();

            System.out.println("Got event: " + currentEvent);
            SensorEventLoopType.valueOf(eventType.toString()).callRoomElement(smartHome, eventType, eventObjectId);
            currentEvent = new SensorEventGenerator().getNextSensorEvent();
        }
    }
}

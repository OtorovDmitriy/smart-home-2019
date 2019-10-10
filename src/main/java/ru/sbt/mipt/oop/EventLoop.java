package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

class EventLoop {

    static void Handling(SensorEvent event, SmartHome smartHome) {
        SensorEvent currentEvent = event;

        while (currentEvent != null) {
            SensorEventType eventType = currentEvent.getType();
            String eventObjectId = currentEvent.getObjectId();

            System.out.println("Got event: " + currentEvent);
            if (eventType == LIGHT_ON || eventType == LIGHT_OFF) {
                Light.Switch(eventObjectId, eventType, smartHome);
            }
            if (eventType == DOOR_OPEN || eventType == DOOR_CLOSED) {
                Door.Switch(eventObjectId, eventType, smartHome);
            }
            currentEvent = SensorEvent.getNextSensorEvent();
        }
    }
}

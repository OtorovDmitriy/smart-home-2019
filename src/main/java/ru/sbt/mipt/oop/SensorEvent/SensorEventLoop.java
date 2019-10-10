package ru.sbt.mipt.oop.SensorEvent;

import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.SensorEvent.SensorEventType.*;
import static ru.sbt.mipt.oop.SensorEvent.SensorEventType.DOOR_CLOSED;

public class SensorEventLoop {

    public static void Handling(SensorEvent event, SmartHome smartHome) {
        SensorEvent currentEvent = event;

        while (currentEvent != null) {
            SensorEventType eventType = currentEvent.getType();
            String eventObjectId = currentEvent.getObjectId();

            System.out.println("Got event: " + currentEvent);
            if (eventType == LIGHT_ON || eventType == LIGHT_OFF) {
                new SensorEventLight(eventType, eventObjectId).Switch(smartHome);
            }
            if (eventType == DOOR_OPEN || eventType == DOOR_CLOSED) {
                new SensorEventDoor(eventType, eventObjectId).Switch(smartHome);
            }
            currentEvent = SensorEvent.getNextSensorEvent();
        }
    }
}

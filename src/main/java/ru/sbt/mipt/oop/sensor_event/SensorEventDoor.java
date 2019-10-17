package ru.sbt.mipt.oop.sensor_event;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.additional_tools.RoomDoorState;

public class SensorEventDoor extends SensorEvent {
    public SensorEventDoor(SensorEventType type, String objectId) {
        super(type, objectId);
    }

    public void switchDoorState(SmartHome smartHome) {
        SensorEventType type = this.getType();
        String objectId = this.getObjectId();

        new RoomDoorState().changeDoorState(smartHome, type, objectId);
    }
}

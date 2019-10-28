package ru.sbt.mipt.oop.sensor.event;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.additional.tools.RoomDoorState;

public class SensorEventDoor extends SensorEvent implements SensorEventElement {
    SensorEventDoor(SensorEventType type, String objectId) {
        super(type, objectId);
    }

    @Override
    public void switchElementState(SmartHome smartHome) {
        SensorEventType type = this.getType();
        String objectId = this.getObjectId();

        new RoomDoorState().changeStateOfRoomElement(smartHome, type, objectId);
    }
}

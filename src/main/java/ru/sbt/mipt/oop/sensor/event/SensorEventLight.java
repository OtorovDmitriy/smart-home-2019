package ru.sbt.mipt.oop.sensor.event;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.additional.tools.RoomLightState;

public class SensorEventLight extends SensorEvent {

    public SensorEventLight(SensorEventType type, String ObjectId) {
        super(type, ObjectId);
    }

    public void switchLightState(SmartHome smartHome) {
        SensorEventType type = this.getType();
        String objectId = this.getObjectId();

        new RoomLightState().changeStateOfRoomElement(smartHome, type, objectId);
    }
}

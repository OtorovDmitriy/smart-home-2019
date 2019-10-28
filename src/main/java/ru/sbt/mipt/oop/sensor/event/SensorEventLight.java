package ru.sbt.mipt.oop.sensor.event;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.additional.tools.RoomLightState;

public class SensorEventLight extends SensorEvent implements SensorEventElement {

    SensorEventLight(SensorEventType type, String ObjectId) {
        super(type, ObjectId);
    }

    @Override
    public void switchElementState(SmartHome smartHome) {
        SensorEventType type = this.getType();
        String objectId = this.getObjectId();

        new RoomLightState().changeStateOfRoomElement(smartHome, type, objectId);
    }
}

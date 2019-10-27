package ru.sbt.mipt.oop.additional.tools;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor.event.SensorEventType;

public interface RoomElementState {
    public void changeStateOfRoomElement(SmartHome smartHome, SensorEventType type, String objectId);
}

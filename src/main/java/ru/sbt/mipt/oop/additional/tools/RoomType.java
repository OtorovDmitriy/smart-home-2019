package ru.sbt.mipt.oop.additional.tools;

import ru.sbt.mipt.oop.sensor.event.SensorEventAllLights;
import ru.sbt.mipt.oop.SmartHome;

public class RoomType {

    public void checkRoomType(String roomType, SmartHome smartHome) {
        if (roomType.equals("hall")) {
            new SensorEventAllLights().switchElementState(smartHome);
        }
    }
}

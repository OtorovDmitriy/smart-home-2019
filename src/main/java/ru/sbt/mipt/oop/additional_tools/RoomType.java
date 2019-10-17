package ru.sbt.mipt.oop.additional_tools;

import ru.sbt.mipt.oop.sensor_event.SensorEventAllLights;
import ru.sbt.mipt.oop.SmartHome;

public class RoomType {

    public void checkRoomType(String roomType, SmartHome smartHome) {
        if (roomType.equals("hall")) {
            new SensorEventAllLights().switchAllLights(smartHome);
        }
    }
}

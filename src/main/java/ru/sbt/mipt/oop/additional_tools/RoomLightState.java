package ru.sbt.mipt.oop.additional_tools;

import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room_elements.Light;
import ru.sbt.mipt.oop.sensor_event.SensorEventType;

public class RoomLightState {

    public void changeLightState(SmartHome smartHome, SensorEventType type, String objectId) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(objectId)) {
                    if (type == SensorEventType.LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                    } else {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                    }
                }
            }
        }
    }
}

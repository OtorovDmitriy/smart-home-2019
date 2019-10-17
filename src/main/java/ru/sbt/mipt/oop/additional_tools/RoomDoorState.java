package ru.sbt.mipt.oop.additional_tools;

import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room_elements.Door;
import ru.sbt.mipt.oop.sensor_event.SensorEventType;

public class RoomDoorState {

    public void changeDoorState(SmartHome smartHome, SensorEventType type, String objectId) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(objectId)) {
                    if (type == SensorEventType.DOOR_OPEN) {
                        door.setOpen(true);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                    } else {
                        door.setOpen(false);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                        new RoomType().checkRoomType(room.getName(), smartHome);
                    }
                }
            }
        }
    }
}
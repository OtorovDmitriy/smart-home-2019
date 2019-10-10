package ru.sbt.mipt.oop.SensorEvent;

import ru.sbt.mipt.oop.*;

import static ru.sbt.mipt.oop.SensorEvent.SensorEventType.DOOR_OPEN;

public class SensorEventDoor extends SensorEvent {
    public SensorEventDoor(SensorEventType type, String objectId) {
        super(type, objectId);
    }

    public void Switch(SmartHome smartHome) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(this.getObjectId())) {
                    if (this.getType() == DOOR_OPEN) {
                        door.setOpen(true);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                    } else {
                        door.setOpen(false);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");

                        if (room.getName().equals("hall")) {
                            SensorEventLight.SwitchAllLights(smartHome);
                        }
                    }
                }
            }
        }
    }
}

package ru.sbt.mipt.oop.event.processor;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room.elements.Door;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;
import ru.sbt.mipt.oop.sensor.event.SensorEventType;

public class DoorEventProcessor implements EventProcessor {
    @Override
    public void Process(SmartHome smartHome, SensorEvent sensorEvent) {
        smartHome.execute(object -> {
            if (!(object instanceof Door)) return;
            Door door = (Door) object;
            changeDoorState(door, sensorEvent);
        });
    }

    private void changeDoorState(Door door, SensorEvent sensorEvent) {
        if (door.getId().equals(sensorEvent.getObjectId())) {
            if (sensorEvent.getType() == SensorEventType.DOOR_OPEN) {
                door.setOpen(true);
                System.out.println("Door " + door.getId() + " in room " + door.getId() + " was opened.");
            } else {
                door.setOpen(false);
                System.out.println("Door " + door.getId() + " in room " + door.getId() + " was closed.");
            }
        }
    }
}

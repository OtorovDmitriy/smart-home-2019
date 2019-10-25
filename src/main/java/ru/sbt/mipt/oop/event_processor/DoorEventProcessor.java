package ru.sbt.mipt.oop.event_processor;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room_elements.Door;
import ru.sbt.mipt.oop.sensor_event.SensorEvent;
import ru.sbt.mipt.oop.sensor_event.SensorEventType;

public class DoorEventProcessor implements EventProcessor {
    @Override
    public void Process(SmartHome smartHome, SensorEvent sensorEvent) {

        if (smartHome.getAlarmActivated()) {
            System.out.println("Sending sms...");
            return;
        }

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

package ru.sbt.mipt.oop.event.processor;

import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room.elements.Door;
import ru.sbt.mipt.oop.room.elements.Light;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;
import ru.sbt.mipt.oop.sensor.event.SensorEventType;

public class HallDoorEventProcessor implements EventProcessor {
    @Override
    public void Process(SmartHome smartHome, SensorEvent sensorEvent) {
        smartHome.execute(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.execute(doorObject -> {
                        if (!(doorObject instanceof Door)) return;
                        Door door = (Door) doorObject;
                        if (door.getId().equals(sensorEvent.getObjectId()) && door.getState()) {
                            this.changeAllLightState(smartHome, sensorEvent);
                        }
                    });
                }
            }
        });
    }

    private void changeAllLightState(SmartHome smartHome, SensorEvent sensorEvent) {
        if (sensorEvent.getType() != SensorEventType.DOOR_CLOSED) return;

        smartHome.execute(object -> {
            if (!(object instanceof Light)) return;
            Light light = (Light) object;
            if (light.getState()) {
                light.changeState(false);
                System.out.println("- Light: " + light.getId() + " was turned off");
            }
        });
    }
}
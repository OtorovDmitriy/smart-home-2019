package ru.sbt.mipt.oop.event_processor;

import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room_elements.Light;
import ru.sbt.mipt.oop.sensor_event.SensorEvent;

import static ru.sbt.mipt.oop.sensor_event.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.sensor_event.SensorEventType.LIGHT_ON;


public class LightEventProcessor implements EventProcessor {
    @Override
    public void Process(SmartHome smartHome, SensorEvent sensorEvent) {

        if (!(sensorEvent.getType() == LIGHT_ON || sensorEvent.getType() == LIGHT_OFF)) return;

        smartHome.execute(object -> {
            if (!(object instanceof Room)) return;
            Room room = (Room) object;

            if (room.getName().equals("Hall")) {
                smartHome.execute(light -> {
                    if (!(light instanceof Light)) return;
                    Light l = (Light) object;
                    l.setOn(false);
                });
            }
        });

        smartHome.execute(object -> {
            if (!(object instanceof Light)) return;
            Light light = (Light) object;
            changeLightState(light, sensorEvent);
        });
    }

    private void changeLightState(Light light, SensorEvent sensorEvent) {
        if (light.getId().equals(sensorEvent.getObjectId())) {
            if (sensorEvent.getType() == LIGHT_ON) {
                light.setOn(true);
                System.out.println("Light: " + light.getId() + " was turned on");
            } if (sensorEvent.getType() == LIGHT_OFF) {
                light.setOn(false);
                System.out.println("Light: " + light.getId() + " was turned off");
            }
        }
    }
}

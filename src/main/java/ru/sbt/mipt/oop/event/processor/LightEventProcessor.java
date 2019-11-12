package ru.sbt.mipt.oop.event.processor;

import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room.elements.Light;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;

import static ru.sbt.mipt.oop.sensor.event.SensorEventType.LIGHT_ON;
import static ru.sbt.mipt.oop.sensor.event.SensorEventType.LIGHT_OFF;


public class LightEventProcessor implements EventProcessor {
    @Override
    public void Process(SmartHome smartHome, SensorEvent sensorEvent) {

        smartHome.execute(object -> {
            if (!(object instanceof Room)) return;
            Room room = (Room) object;

            if (room.getName().equals("Hall")) {
                this.changeAllLightState(smartHome);
            }
        });

        smartHome.execute(object -> {
            if (!(object instanceof Light)) return;
            Light light = (Light) object;
            changeLightState(light, sensorEvent);
        });
    }

    private void changeAllLightState(SmartHome smartHome) {
        smartHome.execute(object -> {
            if (!(object instanceof Light)) return;
            Light light = (Light) object;
            light.changeState();
        });
    }

    private void changeLightState(Light light, SensorEvent sensorEvent) {
        if (light.getId().equals(sensorEvent.getObjectId())) {
            if (sensorEvent.getType() == LIGHT_ON) {
                light.changeState();
                System.out.println("Light: " + light.getId() + " was turned on");
            } else if (sensorEvent.getType() == LIGHT_OFF) {
                light.changeState();
                System.out.println("Light: " + light.getId() + " was turned off");
            }
        }
    }
}

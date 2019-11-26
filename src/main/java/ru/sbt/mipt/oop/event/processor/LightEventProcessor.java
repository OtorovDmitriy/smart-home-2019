package ru.sbt.mipt.oop.event.processor;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room.elements.Light;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;

import static ru.sbt.mipt.oop.sensor.event.SensorEventType.LIGHT_ON;
import static ru.sbt.mipt.oop.sensor.event.SensorEventType.LIGHT_OFF;

public class LightEventProcessor implements EventProcessor {
    @Override
    public void process(SmartHome smartHome, SensorEvent sensorEvent) {
        smartHome.execute(object -> {
            if (!(object instanceof Light)) return;
            Light light = (Light) object;
            changeLightState(light, sensorEvent);
        });
    }

    private void changeLightState(Light light, SensorEvent sensorEvent) {
        if (light.getId().equals(sensorEvent.getObjectId())) {
            if (sensorEvent.getType() == LIGHT_ON && !light.getState()) {
                light.changeState(true);
                System.out.println("Light: " + light.getId() + " was turned on");
            } else if (sensorEvent.getType() == LIGHT_OFF && light.getState()) {
                light.changeState(false);
                System.out.println("Light: " + light.getId() + " was turned off");
            }
        }
    }
}

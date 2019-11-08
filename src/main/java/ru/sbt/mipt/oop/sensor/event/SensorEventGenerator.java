package ru.sbt.mipt.oop.sensor.event;

import java.util.UUID;

import static ru.sbt.mipt.oop.sensor.event.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.sensor.event.SensorEventType.ALARM_DEACTIVATE;

public class SensorEventGenerator {

    public SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null;
        SensorEventType sensorEventType = SensorEventType.values()[(int) (6 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        if (sensorEventType == ALARM_ACTIVATE || sensorEventType == ALARM_DEACTIVATE) {
            String code = UUID.randomUUID().toString().replace("-", "").toUpperCase();
            return new SensorEvent(sensorEventType, objectId, code);
        } else {
            return new SensorEvent(sensorEventType, objectId);
        }
    }
}

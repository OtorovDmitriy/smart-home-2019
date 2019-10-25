package ru.sbt.mipt.oop.sensor_event;
import java.util.UUID;

public class SensorEventGenerator {

    public SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null;
        SensorEventType sensorEventType = SensorEventType.values()[(int) (6 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        String code = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        return new SensorEvent(sensorEventType, objectId, code);
    }
}

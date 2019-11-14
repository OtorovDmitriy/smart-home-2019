package ru.sbt.mipt.oop.sensor.event;

public class SensorEventGenerator {

    public SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null;
        SensorEventType sensorEventType = SensorEventType.values()[(int) (6 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));

        if (sensorEventType.equals(SensorEventType.ALARM_ACTIVATE) || sensorEventType.equals(SensorEventType.ALARM_DEACTIVATE)) {
            sensorEventType.setCode("LTCNRHC287ENGX");
            return new SensorEvent(sensorEventType, objectId);
        } else {
            return new SensorEvent(sensorEventType, objectId);
        }
    }
}

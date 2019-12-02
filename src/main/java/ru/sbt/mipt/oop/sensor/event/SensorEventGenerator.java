package ru.sbt.mipt.oop.sensor.event;

public class SensorEventGenerator {

    public SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null;
        SensorEventType sensorEventType = SensorEventType.values()[(int) (6 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));

        if (sensorEventType.equals(SensorEventType.ALARM_ACTIVATE) || sensorEventType.equals(SensorEventType.ALARM_DEACTIVATE)) {
            SensorEventAlarm sensorEventAlarm = new SensorEventAlarm(sensorEventType, objectId);
            sensorEventAlarm.setCode("LTCNRHC287ENGX");
            return sensorEventAlarm;
        } else if (sensorEventType.equals(SensorEventType.DOOR_OPEN) || sensorEventType.equals(SensorEventType.DOOR_CLOSED)) {
            return new SensorEventDoor(sensorEventType, objectId);
        } else {
            return new SensorEventLight(sensorEventType, objectId);
        }
    }
}

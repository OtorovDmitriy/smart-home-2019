package ru.sbt.mipt.oop.sensor.event;

public class SensorEventAlarm implements SensorEvent {
    private final SensorEventType type;
    private final String objectId;
    private String code;

    public SensorEventAlarm(SensorEventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    @Override
    public SensorEventType getType() {
        return this.type;
    }

    @Override
    public String getObjectId() {
        return this.objectId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}

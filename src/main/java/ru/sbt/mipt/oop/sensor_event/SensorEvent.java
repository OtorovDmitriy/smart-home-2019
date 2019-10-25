package ru.sbt.mipt.oop.sensor_event;

public class SensorEvent {
    private final SensorEventType type;
    private final String objectId;
    private String code;

    public SensorEvent(SensorEventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    public SensorEvent(SensorEventType type, String objectId, String code) {
        this.type = type;
        this.objectId = objectId;
        this.code = code;
    }

    public SensorEventType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "deactivationCode=" + code +
                " type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}

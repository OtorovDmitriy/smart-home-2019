package ru.sbt.mipt.oop.sensor_event;

public class SensorEvent {
    private final SensorEventType type;
    private final String objectId;
    private String deactivationCode;

    public SensorEvent(SensorEventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    public SensorEvent(SensorEventType type, String objectId, String deactivationCode) {
        this.type = type;
        this.objectId = objectId;
        this.deactivationCode = deactivationCode;
    }

    public SensorEventType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getDeactivationCode() {
        return deactivationCode;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "deactivationCode=" + deactivationCode +
                " type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}

package ru.sbt.mipt.oop.sensor.event;

public class SensorEventLight implements SensorEvent {
    private final SensorEventType type;
    private final String objectId;

    public SensorEventLight(SensorEventType type, String objectId) {
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

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}

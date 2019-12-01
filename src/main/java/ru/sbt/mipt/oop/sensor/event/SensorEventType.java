
package ru.sbt.mipt.oop.sensor.event;

public enum SensorEventType {
    LIGHT_ON, LIGHT_OFF, DOOR_OPEN, DOOR_CLOSED, ALARM_ACTIVATE("Null"), ALARM_DEACTIVATE("Null");

    private String code;

    SensorEventType() {
    }

    SensorEventType(String code) {
        this.code = code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}

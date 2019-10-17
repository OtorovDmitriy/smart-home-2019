package ru.sbt.mipt.oop.sensor_event;

import ru.sbt.mipt.oop.SmartHome;

public enum SensorEventLoopType {
    LIGHT_ON {
        @Override
        public void callRoomElement(SmartHome smartHome, SensorEventType eventType, String eventObjectId) {
            new SensorEventLight(eventType, eventObjectId).switchLightState(smartHome);
        }
    },

    LIGHT_OFF {
        @Override
        public void callRoomElement(SmartHome smartHome, SensorEventType eventType, String eventObjectId) {
            new SensorEventLight(eventType, eventObjectId).switchLightState(smartHome);
        }
    },

    DOOR_OPEN() {
        @Override
        public void callRoomElement(SmartHome smartHome, SensorEventType eventType, String eventObjectId) {
            new SensorEventDoor(eventType, eventObjectId).switchDoorState(smartHome);
        }
    },

    DOOR_CLOSED() {
        @Override
        public void callRoomElement(SmartHome smartHome, SensorEventType eventType, String eventObjectId) {
            new SensorEventDoor(eventType, eventObjectId).switchDoorState(smartHome);
        }
    };

    public abstract void callRoomElement(SmartHome smartHome, SensorEventType eventType, String eventObjectId);
}

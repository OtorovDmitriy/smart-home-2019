package ru.sbt.mipt.oop.event.processor.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;
import ru.sbt.mipt.oop.sensor.event.SensorEventType;

public class DoorEventAdapter implements CCSensorEventAdapter {
    private CCSensorEventAdapter ccSensorEventAdapter;

    public DoorEventAdapter(CCSensorEventAdapter ccSensorEventAdapter) {
        this.ccSensorEventAdapter = ccSensorEventAdapter;
    }

    @Override
    public SensorEvent convert(CCSensorEvent ccSensorEvent) {
        if (ccSensorEvent.getEventType().equals("DoorIsOpen") || ccSensorEvent.getEventType().equals("DoorIsUnlocked")) {
            return new SensorEvent(SensorEventType.DOOR_OPEN, ccSensorEvent.getObjectId());
        } else if (ccSensorEvent.getEventType().equals("DoorIsClosed") || ccSensorEvent.getEventType().equals("DoorIsLocked")) {
            return new SensorEvent(SensorEventType.DOOR_CLOSED, ccSensorEvent.getObjectId());
        } else if (ccSensorEventAdapter == null) {
            return null;
        }
        return ccSensorEventAdapter.convert(ccSensorEvent);
    }
}

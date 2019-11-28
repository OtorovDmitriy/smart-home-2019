package ru.sbt.mipt.oop.event.processor.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;
import ru.sbt.mipt.oop.sensor.event.SensorEventType;

public class LightEventAdapter implements CCSensorEventAdapter {
    private CCSensorEventAdapter ccSensorEventAdapter;

    public LightEventAdapter(CCSensorEventAdapter ccSensorEventAdapter) {
        this.ccSensorEventAdapter = ccSensorEventAdapter;
    }

    @Override
    public SensorEvent convert(CCSensorEvent ccSensorEvent) {
        if (ccSensorEvent.getEventType().equals("LightIsOn")) {
            return new SensorEvent(SensorEventType.LIGHT_ON, ccSensorEvent.getObjectId());
        } else if (ccSensorEvent.getEventType().equals("LightIsOff")) {
            return new SensorEvent(SensorEventType.LIGHT_OFF, ccSensorEvent.getObjectId());
        } else if (ccSensorEventAdapter == null) {
            return null;
        }
        return ccSensorEventAdapter.convert(ccSensorEvent);
    }
}
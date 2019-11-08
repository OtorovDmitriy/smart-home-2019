package ru.sbt.mipt.oop.api;

import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;
import ru.sbt.mipt.oop.sensor.event.SensorEventLoop;
import ru.sbt.mipt.oop.sensor.event.SensorEventType;

import java.util.*;

public class SensorEventsManagerAdapter extends SensorEventLoop {
    private SensorEventsManager sensorEventsManager;

    public SensorEventsManagerAdapter(SensorEventsManager sensorEventsManager) {
        this.sensorEventsManager = sensorEventsManager;
    }

    public List<SensorEvent> getSensorEventList() {
        HashMap<String, String> CCSensorEventMap = new HashMap<>();
        List<SensorEvent> sensorEventsArray = new ArrayList<>();

        this.sensorEventsManager.registerEventHandler(event -> {
            CCSensorEventMap.put(event.getObjectId(), event.getEventType());
        });
        this.sensorEventsManager.start();

        for (Map.Entry<String, String> item : CCSensorEventMap.entrySet()) {
            String objectId = item.getKey();
            String objectType = item.getValue();

            switch (objectType) {
                case ("LightIsOn"):
                    objectType = "LIGHT_ON";
                    break;
                case ("LightIsOff"):
                    objectType = "LIGHT_OFF";
                    break;
                case ("DoorIsOpen"):
                    objectType = "DOOR_OPEN";
                    break;
                case ("DoorIsClosed"):
                    objectType = "DOOR_CLOSED";
                    break;
                case ("DoorIsLocked"):
                    objectType = "ALARM_ACTIVATE";
                    break;
                case ("DoorIsUnlocked"):
                    objectType = "ALARM_DEACTIVATE";
                    break;
            }

            if (objectType.equals("ALARM_ACTIVATE") || objectType.equals("ALARM_DEACTIVATE")) {
                String code = UUID.randomUUID().toString().replace("-", "").toUpperCase();
                SensorEvent sensorEvent = new SensorEvent(SensorEventType.valueOf(objectType), objectId, code);
                sensorEventsArray.add(sensorEvent);
            } else {
                SensorEvent sensorEvent = new SensorEvent(SensorEventType.valueOf(objectType), objectId);
                sensorEventsArray.add(sensorEvent);
            }
        }

        return sensorEventsArray;
    }
}
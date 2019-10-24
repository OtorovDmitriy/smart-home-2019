package ru.sbt.mipt.oop.event_processor;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor_event.SensorEvent;
import ru.sbt.mipt.oop.sensor_event.SensorEventType;

public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void Process(SmartHome smartHome, SensorEvent sensorEvent) {
        smartHome.execute(object -> {
            if (!(object instanceof SmartHome)) return;
            if (sensorEvent.getType() == SensorEventType.ALARM_ACTIVATE) {
                System.out.println("Alarm activated.");
            } else {
                System.out.println("Alarm deactivated.");
            }
        });
    }
}

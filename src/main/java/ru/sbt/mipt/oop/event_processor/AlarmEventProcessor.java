package ru.sbt.mipt.oop.event_processor;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.ActivateAlarm;
import ru.sbt.mipt.oop.alarm.DeactivateAlarm;
import ru.sbt.mipt.oop.sensor_event.SensorEvent;

import static ru.sbt.mipt.oop.sensor_event.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.sensor_event.SensorEventType.ALARM_DEACTIVATE;

public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void Process(SmartHome smartHome, SensorEvent sensorEvent) {
        smartHome.execute(object -> {
            if (!(object instanceof SmartHome)) return;

            if (sensorEvent.getType() == ALARM_ACTIVATE) {
                new ActivateAlarm(smartHome, sensorEvent.getCode()).activate();
            } else if (sensorEvent.getType() == ALARM_DEACTIVATE) {
                new DeactivateAlarm(smartHome, sensorEvent.getCode()).activate();
            } else {
                return;
            }
        });
    }
}

package ru.sbt.mipt.oop.event.processor;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;
import ru.sbt.mipt.oop.sensor.event.SensorEventType;

public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void Process(SmartHome smartHome, SensorEvent sensorEvent) {

        smartHome.execute(object -> {
            if (!(object instanceof Alarm)) return;
            Alarm alarm = (Alarm) object;
            changeAlarmState(alarm, sensorEvent);
        });
    }

    private void changeAlarmState(Alarm alarm, SensorEvent sensorEvent) {
        if (sensorEvent.getType() == SensorEventType.ALARM_ACTIVATE) {
            alarm.activate();
        } else if (sensorEvent.getType() == SensorEventType.ALARM_DEACTIVATE) {
            alarm.deactivate();

//            String tempCode = SensorEventType.ALARM_DEACTIVATE.getCode();
//            if (alarm.checkCode(tempCode)) {
//                alarm.deactivate();
//            } else {
//                setOnAlertAlert(alarm);
//            }
        }
    }
}
package ru.sbt.mipt.oop.event.processor;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.ActivateAlarm;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlertAlarm;
import ru.sbt.mipt.oop.alarm.DeactivateAlarm;
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
            if (!alarm.getAlarmState()) {
                alarm.setState(new ActivateAlarm());
                alarm.activate();
            } else {
                setOnAlertAlert(alarm);
            }
        } else if (sensorEvent.getType() == SensorEventType.ALARM_DEACTIVATE) {
            String tempCode = SensorEventType.ALARM_DEACTIVATE.getCode();
            if (alarm.checkCode(tempCode)) {
                alarm.setState(new DeactivateAlarm());
                alarm.activate();
            } else {
                setOnAlertAlert(alarm);
            }
        }
    }

    private void setOnAlertAlert(Alarm alarm) {
        alarm.setState(new AlertAlarm());
        alarm.activate();
    }
}

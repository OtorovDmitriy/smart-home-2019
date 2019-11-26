package ru.sbt.mipt.oop.event.processor;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;
import ru.sbt.mipt.oop.sensor.event.SensorEventType;

public class EventProcessorDecorator implements EventProcessor {
    private EventProcessor eventProcessor;


    public EventProcessorDecorator(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }

    @Override
    public void process(SmartHome smartHome, SensorEvent sensorEvent) {
        Alarm alarm = smartHome.getAlarm();
        if (alarm.getAlarmState() && sensorEvent.getType() != SensorEventType.ALARM_DEACTIVATE) {
            alarm.enableAlert();
        } else {
            this.eventProcessor.process(smartHome, sensorEvent);
        }
    }
}

package ru.sbt.mipt.oop.event.processor;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.alarm.Activated;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;
import ru.sbt.mipt.oop.sensor.event.SensorEventType;

import java.util.List;

public class EventProcessorDecorator implements EventProcessor {
    private List<EventProcessor> processors;

    public void setEventProcessor(List<EventProcessor> processors) {
        this.processors = processors;
    }

    @Override
    public void process(SmartHome smartHome, SensorEvent sensorEvent) {
        Alarm alarm = smartHome.getAlarm();
        if (alarm.getAlarmState() instanceof Activated && sensorEvent.getType() != SensorEventType.ALARM_DEACTIVATE) {
            System.out.println("Sending SMS...");
            alarm.enableAlert();
        } else {
            for (EventProcessor processor : processors) {
                processor.process(smartHome, sensorEvent);
            }
        }
    }
}

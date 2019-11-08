package ru.sbt.mipt.oop.sensor.event;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.processor.EventProcessor;

import java.util.List;

import static ru.sbt.mipt.oop.sensor.event.SensorEventType.ALARM_DEACTIVATE;

public class SensorEventChangeState {

    public void changeStateOfRoomElement(SensorEventLoop sensorEventLoop, List<EventProcessor> processors, SmartHome smartHome) {

        List<SensorEvent> sensorEventList = sensorEventLoop.getSensorEventList();

        for (SensorEvent currentEvent : sensorEventList) {
            String prevObject = "";
            for (EventProcessor processor : processors) {
                if (smartHome.getAlarm().getAlarmActivatedStatus()) {
                    if (currentEvent.getType() == ALARM_DEACTIVATE) {
                        processor.Process(smartHome, currentEvent);
                    } else {
                        System.out.println("Sending sms...");
                    }
                } else {
                    if (!prevObject.equals(currentEvent.getObjectId() + currentEvent.getType())) {
                        System.out.println("Got event: " + currentEvent);
                        prevObject = currentEvent.getObjectId() + currentEvent.getType();
                    }
                    processor.Process(smartHome, currentEvent);
                }
            }
        }
    }
}

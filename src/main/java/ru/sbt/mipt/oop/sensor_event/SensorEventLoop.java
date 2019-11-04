package ru.sbt.mipt.oop.sensor_event;

import ru.sbt.mipt.oop.event_processor.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;

import java.util.List;

import static ru.sbt.mipt.oop.sensor_event.SensorEventType.ALARM_DEACTIVATE;

public class SensorEventLoop {

    public void changeStateOfRoomElement(List<SensorEvent> sensorEventList, List<EventProcessor> processors, SmartHome smartHome) {
//        SensorEvent currentEvent = new SensorEventGenerator().getNextSensorEvent();
//
//        while (currentEvent != null) {
//            String prevObject = "";
//
//            for (EventProcessor processor : processors) {
//                if (smartHome.getAlarm().getAlarmActivatedStatus()) {
//                    if (currentEvent.getType() == ALARM_DEACTIVATE) {
//                        processor.Process(smartHome, currentEvent);
//                    } else {
//                        System.out.println("Sending sms...");
//                    }
//                } else {
//                    if (!prevObject.equals(currentEvent.getObjectId() + currentEvent.getType())) {
//                        System.out.println("Got event: " + currentEvent);
//                        prevObject = currentEvent.getObjectId() + currentEvent.getType();
//                    }
//                    processor.Process(smartHome, currentEvent);
//                }
//            }
//            currentEvent = new SensorEventGenerator().getNextSensorEvent();
//        }

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
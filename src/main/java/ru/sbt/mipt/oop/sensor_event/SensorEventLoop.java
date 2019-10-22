package ru.sbt.mipt.oop.sensor_event;

import ru.sbt.mipt.oop.event_processor.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;

import java.util.List;

public class SensorEventLoop {

    public void changeStateOfRoomElement(List<EventProcessor> processors, SmartHome smartHome) {
        SensorEvent currentEvent = new SensorEventGenerator().getNextSensorEvent();

        while (currentEvent != null) {
            System.out.println("Got event: " + currentEvent);
            for (EventProcessor processor : processors) {
                processor.Process(smartHome, currentEvent);
            }
            currentEvent = new SensorEventGenerator().getNextSensorEvent();
        }
    }
}

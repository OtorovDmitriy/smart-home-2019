package ru.sbt.mipt.oop.sensor.event;

import ru.sbt.mipt.oop.event.processor.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;

import java.util.List;

public class SensorEventLoop {

    public void changeStateOfRoomElement(List<EventProcessor> processors, SmartHome smartHome) {
        SensorEventGenerator sensorEventGenerator = new SensorEventGenerator();
        SensorEvent currentEvent = sensorEventGenerator.getNextSensorEvent();

        while (currentEvent != null) {
            System.out.println("Got event: " + currentEvent);

            for (EventProcessor processor : processors) {
                processor.Process(smartHome, currentEvent);
            }

            currentEvent = sensorEventGenerator.getNextSensorEvent();
        }
    }
}

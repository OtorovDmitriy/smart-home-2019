package ru.sbt.mipt.oop.sensor.event;

import ru.sbt.mipt.oop.event.processor.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.processor.EventProcessorDecorator;

import java.util.List;

public class SensorEventLoop {

    public void changeStateOfRoomElement(SensorEventGenerator sensorEventGenerator, List<EventProcessor> processors, SmartHome smartHome) {
        SensorEvent currentEvent = sensorEventGenerator.getNextSensorEvent();

        while (currentEvent != null) {
            System.out.println("Got event: " + currentEvent);

            for (EventProcessor processor : processors) {
                new EventProcessorDecorator(processor).Process(smartHome, currentEvent);
            }

            currentEvent = sensorEventGenerator.getNextSensorEvent();
        }
    }
}

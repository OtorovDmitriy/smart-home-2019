package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.processor.DoorEventProcessor;
import ru.sbt.mipt.oop.event.processor.EventProcessor;
import ru.sbt.mipt.oop.event.processor.HallDoorEventProcessor;
import ru.sbt.mipt.oop.event.processor.LightEventProcessor;
import ru.sbt.mipt.oop.file.reader.ReadFromJSON;
import ru.sbt.mipt.oop.sensor.event.SensorEventGenerator;
import ru.sbt.mipt.oop.sensor.event.SensorEventLoop;
import ru.sbt.mipt.oop.additional.tools.GsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) throws IOException {
        ReadFromJSON readFromJSON = new ReadFromJSON("smart-home-1.js");
        String JSONResult = readFromJSON.readInputData();

        SmartHome smartHome = GsonObject.createGsonObject(JSONResult, SmartHome.class);

        List<EventProcessor> processors = new ArrayList<>();
        processors.add(new HallDoorEventProcessor());
        processors.add(new DoorEventProcessor());
        processors.add(new LightEventProcessor());

        SensorEventGenerator sensorEventGenerator = new SensorEventGenerator();
        SensorEventLoop sensorEventLoop = new SensorEventLoop();
        sensorEventLoop.changeStateOfRoomElement(sensorEventGenerator, processors, smartHome);
    }
}

package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.file.reader.ReadFromJSON;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;
import ru.sbt.mipt.oop.sensor.event.SensorEventGenerator;
import ru.sbt.mipt.oop.sensor.event.SensorEventLoop;

import java.io.IOException;

public class Main {

    public static void main(String... args) throws IOException {
        ReadFromJSON JSONFileReader = new ReadFromJSON("smart-home-1.js");
        SmartHome smartHome = JSONFileReader.getSmartHomeObj(SmartHome.class);
        SensorEvent sensorEvent = new SensorEventGenerator().getNextSensorEvent();
        new SensorEventLoop().createSensorEventLoop(sensorEvent, smartHome);
    }
}

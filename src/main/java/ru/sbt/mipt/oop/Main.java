package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.additional.tools.GsonObject;
import ru.sbt.mipt.oop.file.reader.ReadFromJSON;
import ru.sbt.mipt.oop.sensor.event.*;

public class Main {

    public static void main(String... args) {
        ReadFromJSON readFromJSON = new ReadFromJSON("smart-home-1.js");
        String JSONResult = readFromJSON.readInputData();

        SmartHome smartHome = GsonObject.createGsonObject(JSONResult, SmartHome.class);

        SensorEventGenerator sensorEventGenerator = new SensorEventGenerator();
        SensorEvent sensorEvent = sensorEventGenerator.getNextSensorEvent();
        SensorEventLoop sensorEventLoop = new SensorEventLoop();

        while (sensorEvent != null) {
            System.out.println("Got event: " + sensorEvent);
            sensorEventLoop.cleanList();
            sensorEventLoop.addItem(new SensorEventDoor(sensorEvent.getType(), sensorEvent.getObjectId()));
            sensorEventLoop.addItem(new SensorEventLight(sensorEvent.getType(), sensorEvent.getObjectId()));
            sensorEventLoop.handleEvents(smartHome);
            sensorEvent = sensorEventGenerator.getNextSensorEvent();
        }
    }
}

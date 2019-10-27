package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.file.reader.ReadFromJSON;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;
import ru.sbt.mipt.oop.sensor.event.SensorEventGenerator;
import ru.sbt.mipt.oop.sensor.event.SensorEventLoop;

import java.io.IOException;

public class Main {

    public static void main(String... args) throws IOException {
        ReadFromJSON readFromJSON = new ReadFromJSON("smart-home-1.js");
        String JSONResult = readFromJSON.readInputData();

        Gson gson = new Gson();
        SmartHome smartHome = gson.fromJson(JSONResult, SmartHome.class);

        SensorEvent sensorEvent = new SensorEventGenerator().getNextSensorEvent();
        new SensorEventLoop().createSensorEventLoop(sensorEvent, smartHome);
    }
}

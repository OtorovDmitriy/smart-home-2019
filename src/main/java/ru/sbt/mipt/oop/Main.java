package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.json.JSONFileReader;

import java.io.IOException;

public class Main {

    public static void main(String... args) throws IOException {
        JSONFileReader json = new JSONFileReader("smart-home-1.js");
        SmartHome smartHome = json.fromJson(SmartHome.class);
        EventLoop.Handling(SensorEvent.getNextSensorEvent(), smartHome);
    }
}

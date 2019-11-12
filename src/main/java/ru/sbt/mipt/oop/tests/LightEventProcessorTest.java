package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.additional.tools.GsonObject;
import ru.sbt.mipt.oop.event.processor.EventProcessor;
import ru.sbt.mipt.oop.event.processor.EventProcessorComposite;
import ru.sbt.mipt.oop.event.processor.LightEventProcessor;
import ru.sbt.mipt.oop.file.reader.ReadFromJSON;
import ru.sbt.mipt.oop.room.elements.Light;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;

import java.io.IOException;
import java.util.List;

import static ru.sbt.mipt.oop.sensor.event.SensorEventType.LIGHT_ON;
import static ru.sbt.mipt.oop.sensor.event.SensorEventType.LIGHT_OFF;

public class LightEventProcessorTest {

    @Test
    public void TestLightEventProcessorSetOn() throws IOException {
        ReadFromJSON readFromJSON = new ReadFromJSON("smart-home-1.js");
        String JSONResult = readFromJSON.readInputData();

        SmartHome smartHome = GsonObject.createGsonObject(JSONResult, SmartHome.class);

        EventProcessorComposite eventProcessorComposite = new EventProcessorComposite();
        eventProcessorComposite.addProcessor(new LightEventProcessor());
        List<EventProcessor> processors = eventProcessorComposite.getProcessors();

        SensorEvent currentEvent = new SensorEvent(LIGHT_ON, "1");
        processors.get(0).Process(smartHome, currentEvent);

        boolean isOn = false;

        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals("1")) {
                    isOn = light.isOn();
                }
            }
        }

        Assert.assertTrue(isOn);
    }

    @Test
    public void TestLightEventProcessorSetOff() throws IOException {
        ReadFromJSON readFromJSON = new ReadFromJSON("smart-home-1.js");
        String JSONResult = readFromJSON.readInputData();

        SmartHome smartHome = GsonObject.createGsonObject(JSONResult, SmartHome.class);

        EventProcessorComposite eventProcessorComposite = new EventProcessorComposite();
        eventProcessorComposite.addProcessor(new LightEventProcessor());
        List<EventProcessor> processors = eventProcessorComposite.getProcessors();

        SensorEvent currentEvent = new SensorEvent(LIGHT_OFF, "1");
        processors.get(0).Process(smartHome, currentEvent);

        boolean isOn = true;

        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals("1")) {
                    isOn = light.isOn();
                }
            }
        }

        Assert.assertFalse(isOn);
    }
}
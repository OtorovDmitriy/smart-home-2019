package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event_processor.EventProcessor;
import ru.sbt.mipt.oop.event_processor.EventProcessorComposite;
import ru.sbt.mipt.oop.event_processor.LightEventProcessor;
import ru.sbt.mipt.oop.file_reader.FileReader;
import ru.sbt.mipt.oop.file_reader.FileReaderJSONStrategy;
import ru.sbt.mipt.oop.room_elements.Light;
import ru.sbt.mipt.oop.sensor_event.SensorEvent;

import java.io.IOException;
import java.util.List;

import static ru.sbt.mipt.oop.sensor_event.SensorEventType.LIGHT_ON;
import static ru.sbt.mipt.oop.sensor_event.SensorEventType.LIGHT_OFF;

public class LightEventProcessorTest {

    @Test
    public void TestLightEventProcessorSetOn() throws IOException {
        FileReaderJSONStrategy strategyJSON = new FileReaderJSONStrategy();
        FileReader fileReader = new FileReader(strategyJSON);
        SmartHome smartHome = fileReader.executeStrategy("smart-home-1.js", SmartHome.class);

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

        isOn = true;

        Assert.assertTrue(isOn);
    }

    @Test
    public void TestLightEventProcessorSetOff() throws IOException {
        FileReaderJSONStrategy strategyJSON = new FileReaderJSONStrategy();
        FileReader fileReader = new FileReader(strategyJSON);
        SmartHome smartHome = fileReader.executeStrategy("smart-home-1.js", SmartHome.class);

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

        isOn = false;

        Assert.assertFalse(isOn);
    }
}
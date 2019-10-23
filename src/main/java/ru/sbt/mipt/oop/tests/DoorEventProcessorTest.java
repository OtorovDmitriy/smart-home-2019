package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event_processor.DoorEventProcessor;
import ru.sbt.mipt.oop.event_processor.EventProcessor;
import ru.sbt.mipt.oop.event_processor.EventProcessorComposite;
import ru.sbt.mipt.oop.file_reader.FileReader;
import ru.sbt.mipt.oop.file_reader.FileReaderJSONStrategy;
import ru.sbt.mipt.oop.room_elements.Door;
import ru.sbt.mipt.oop.sensor_event.SensorEvent;

import java.io.IOException;
import java.util.List;

import static ru.sbt.mipt.oop.sensor_event.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.sensor_event.SensorEventType.DOOR_OPEN;

public class DoorEventProcessorTest {

    @Test
    public void TestDoorEventProcessorDoorOpen() throws IOException {
        FileReaderJSONStrategy strategyJSON = new FileReaderJSONStrategy();
        FileReader fileReader = new FileReader(strategyJSON);
        SmartHome smartHome = fileReader.executeStrategy("smart-home-1.js", SmartHome.class);

        EventProcessorComposite eventProcessorComposite = new EventProcessorComposite();
        eventProcessorComposite.addProcessor(new DoorEventProcessor());
        List<EventProcessor> processors = eventProcessorComposite.getProcessors();

        SensorEvent currentEvent = new SensorEvent(DOOR_OPEN, "1");
        processors.get(0).Process(smartHome, currentEvent);

        boolean isOpen = false;

        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals("1")) {
                    isOpen = door.isOpen();
                }
            }
        }

        Assert.assertTrue(isOpen);
    }

    @Test
    public void TestDoorEventProcessorDoorClose() throws IOException {
        FileReaderJSONStrategy strategyJSON = new FileReaderJSONStrategy();
        FileReader fileReader = new FileReader(strategyJSON);
        SmartHome smartHome = fileReader.executeStrategy("smart-home-1.js", SmartHome.class);

        EventProcessorComposite eventProcessorComposite = new EventProcessorComposite();
        eventProcessorComposite.addProcessor(new DoorEventProcessor());
        List<EventProcessor> processors = eventProcessorComposite.getProcessors();

        SensorEvent currentEvent = new SensorEvent(DOOR_CLOSED, "1");
        processors.get(0).Process(smartHome, currentEvent);

        boolean isOpen = true;

        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals("1")) {
                    isOpen = door.isOpen();
                }
            }
        }

        Assert.assertFalse(isOpen);
    }
}
package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event_processor.DoorEventProcessor;
import ru.sbt.mipt.oop.event_processor.EventProcessor;
import ru.sbt.mipt.oop.event_processor.LightEventProcessor;
import ru.sbt.mipt.oop.event_processor.EventProcessorComposite;
import ru.sbt.mipt.oop.file_reader.FileReader;
import ru.sbt.mipt.oop.file_reader.FileReaderJSONStrategy;
import ru.sbt.mipt.oop.sensor_event.SensorEventLoop;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String... args) throws IOException {
        FileReaderJSONStrategy strategyJSON = new FileReaderJSONStrategy();
        FileReader fileReader = new FileReader(strategyJSON);
        SmartHome smartHome = fileReader.executeStrategy("smart-home-1.js", SmartHome.class);

        EventProcessorComposite eventProcessorComposite = new EventProcessorComposite();
        eventProcessorComposite.addProcessor(new LightEventProcessor());
        eventProcessorComposite.addProcessor(new DoorEventProcessor());
        List<EventProcessor> processors = eventProcessorComposite.getProcessors();

        new SensorEventLoop().changeStateOfRoomElement(processors, smartHome);
    }
}

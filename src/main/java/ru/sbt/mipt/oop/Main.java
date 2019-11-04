package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.api.SensorEventsManagerAdapter;
import ru.sbt.mipt.oop.event_processor.*;
import ru.sbt.mipt.oop.file_reader.FileReader;
import ru.sbt.mipt.oop.file_reader.FileReaderJSONStrategy;
import ru.sbt.mipt.oop.sensor_event.SensorEvent;
import ru.sbt.mipt.oop.sensor_event.SensorEventLoop;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String... args) throws IOException {
        FileReaderJSONStrategy strategyJSON = new FileReaderJSONStrategy();
        FileReader fileReader = new FileReader(strategyJSON);
        SmartHome smartHome = fileReader.executeStrategy("smart-home-1.js", SmartHome.class);

        EventProcessorComposite eventProcessorComposite = new EventProcessorComposite();
        eventProcessorComposite.addProcessor(new AlarmEventProcessor());
        eventProcessorComposite.addProcessor(new LightEventProcessor());
        eventProcessorComposite.addProcessor(new DoorEventProcessor());
        List<EventProcessor> processors = eventProcessorComposite.getProcessors();


        SensorEventsManagerAdapter sensorEventsManagerAdapter = new SensorEventsManagerAdapter(new SensorEventsManager());
        List<SensorEvent> sensorEventList = sensorEventsManagerAdapter.getSensorEventList();
        new SensorEventLoop().changeStateOfRoomElement(sensorEventList, processors, smartHome);
    }
}

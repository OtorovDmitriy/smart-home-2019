package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sbt.mipt.oop.api.SensorEventsManagerAdapter;
import ru.sbt.mipt.oop.event_processor.*;
import ru.sbt.mipt.oop.file_reader.FileReader;
import ru.sbt.mipt.oop.sensor_event.SensorEventChangeState;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String... args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        FileReader fileReader = context.getBean("fileReader", FileReader.class);

        SmartHome smartHome = fileReader.executeStrategy("smart-home-1.js", SmartHome.class);

        EventProcessorComposite eventProcessorComposite = context.getBean("eventProcessorComposite", EventProcessorComposite.class);
        eventProcessorComposite.addProcessor(context.getBean("alarmEventProcessor", AlarmEventProcessor.class));
        eventProcessorComposite.addProcessor(context.getBean("lightEventProcessor", LightEventProcessor.class));
        eventProcessorComposite.addProcessor(context.getBean("doorEventProcessor", DoorEventProcessor.class));
        List<EventProcessor> processors = eventProcessorComposite.getProcessors();


        SensorEventsManagerAdapter sensorEventsManagerAdapter = new SensorEventsManagerAdapter(new SensorEventsManager());
        new SensorEventChangeState().changeStateOfRoomElement(sensorEventsManagerAdapter, processors, smartHome);
    }
}

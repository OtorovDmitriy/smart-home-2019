package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.additional.tools.GsonObject;
import ru.sbt.mipt.oop.event.processor.*;
import ru.sbt.mipt.oop.event.processor.adapter.CCSensorEventAdapter;
import ru.sbt.mipt.oop.event.processor.adapter.DoorEventAdapter;
import ru.sbt.mipt.oop.event.processor.adapter.EventHandlerAdapter;
import ru.sbt.mipt.oop.event.processor.adapter.LightEventAdapter;
import ru.sbt.mipt.oop.file.reader.ReadFromJSON;

import java.util.List;

@Configuration
public class SpringConfiguration {

    @Bean
    SensorEventsManager sensorEventsManager(EventProcessor eventProcessor, CCSensorEventAdapter ccSensorEventAdapter) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        EventHandlerAdapter eventHandlerAdapter = new EventHandlerAdapter(eventProcessor, ccSensorEventAdapter, smartHome());
        sensorEventsManager.registerEventHandler(eventHandlerAdapter);
        return sensorEventsManager;
    }

    @Bean
    public EventProcessor eventProcessor(List<EventProcessor> processors) {
        EventProcessorDecorator eventProcessorDecorator = new EventProcessorDecorator();
        eventProcessorDecorator.setEventProcessor(processors);
        return eventProcessorDecorator;
    }

    @Bean
    EventProcessor lightEventProcessor() {
        return new LightEventProcessor();
    }

    @Bean
    EventProcessor hallDoorEventProcessor() {
        return new HallDoorEventProcessor();
    }

    @Bean
    EventProcessor doorEventProcessor() {
        return new DoorEventProcessor();
    }

    @Bean
    EventProcessor alarmEventProcessor() {
        return new AlarmEventProcessor();
    }

    @Bean
    public SmartHome smartHome() {
        ReadFromJSON readFromJSON = new ReadFromJSON("smart-home-1.js");
        String JSONResult = readFromJSON.readInputData();
        return GsonObject.createGsonObject(JSONResult, SmartHome.class);
    }

    @Bean
    public CCSensorEventAdapter ccSensorEventAdapter(DoorEventAdapter doorEventAdapter) {
        return new DoorEventAdapter(doorEventAdapter);
    }

    @Bean
    public DoorEventAdapter doorEventAdapter(LightEventAdapter lightEventAdapter) {
        return new DoorEventAdapter(lightEventAdapter);
    }

    @Bean
    public LightEventAdapter lightEventAdapter() {
        return new LightEventAdapter(null);
    }
}

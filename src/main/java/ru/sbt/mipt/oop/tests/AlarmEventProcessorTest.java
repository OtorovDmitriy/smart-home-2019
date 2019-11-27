package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.additional.tools.GsonObject;
import ru.sbt.mipt.oop.alarm.Activated;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.event.processor.AlarmEventProcessor;
import ru.sbt.mipt.oop.event.processor.DoorEventProcessor;
import ru.sbt.mipt.oop.event.processor.EventProcessor;
import ru.sbt.mipt.oop.event.processor.EventProcessorDecorator;
import ru.sbt.mipt.oop.file.reader.ReadFromJSON;
import ru.sbt.mipt.oop.room.elements.Door;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;
import ru.sbt.mipt.oop.sensor.event.SensorEventType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ru.sbt.mipt.oop.sensor.event.SensorEventType.*;

public class AlarmEventProcessorTest {

    @Test
    public void TestAlarmEventProcessorAlarmActivated() throws IOException {
        ReadFromJSON readFromJSON = new ReadFromJSON("smart-home-1.js");
        String JSONResult = readFromJSON.readInputData();

        SmartHome smartHome = GsonObject.createGsonObject(JSONResult, SmartHome.class);

        List<EventProcessor> processors = new ArrayList<>();
        processors.add(new AlarmEventProcessor());

        SensorEventType sensorEventType = ALARM_ACTIVATE;
        sensorEventType.setCode("LTCNRHC287ENGX");

        SensorEvent sensorEvent = new SensorEvent(sensorEventType, "1");
        EventProcessor eventProcessor = processors.get(0);
        EventProcessorDecorator eventProcessorDecorator = new EventProcessorDecorator();
        eventProcessorDecorator.setEventProcessor(processors);
        eventProcessorDecorator.process(smartHome, sensorEvent);
        Alarm alarm = smartHome.getAlarm();
        Assert.assertTrue(alarm.getAlarmState() instanceof Activated);
    }

    @Test
    public void TestAlarmEventProcessorAlarmDeactivated() throws IOException {
        ReadFromJSON readFromJSON = new ReadFromJSON("smart-home-1.js");
        String JSONResult = readFromJSON.readInputData();

        SmartHome smartHome = GsonObject.createGsonObject(JSONResult, SmartHome.class);

        List<EventProcessor> processors = new ArrayList<>();
        processors.add(new AlarmEventProcessor());

        ArrayList<SensorEventType> sensorEventTypes = new ArrayList<>();
        sensorEventTypes.add(ALARM_ACTIVATE);
        sensorEventTypes.add(ALARM_DEACTIVATE);

        for (SensorEventType sensorEventType : sensorEventTypes) {
            sensorEventType.setCode("LTCNRHC287ENGX");
            SensorEvent sensorEvent = new SensorEvent(sensorEventType, "" + Math.random());
            EventProcessor eventProcessor = processors.get(0);
            EventProcessorDecorator eventProcessorDecorator = new EventProcessorDecorator();
            eventProcessorDecorator.setEventProcessor(processors);
            eventProcessorDecorator.process(smartHome, sensorEvent);
        }

        Alarm alarm = smartHome.getAlarm();
        Assert.assertFalse(alarm.getAlarmState() instanceof Activated);
    }

    @Test
    public void TestAlarmEventProcessorAlarmAlert() throws IOException {
        ReadFromJSON readFromJSON = new ReadFromJSON("smart-home-1.js");
        String JSONResult = readFromJSON.readInputData();

        SmartHome smartHome = GsonObject.createGsonObject(JSONResult, SmartHome.class);

        List<EventProcessor> processors = new ArrayList<>();
        processors.add(new AlarmEventProcessor());
        processors.add(new DoorEventProcessor());

        ArrayList<SensorEventType> sensorEventTypes = new ArrayList<>();
        sensorEventTypes.add(ALARM_ACTIVATE);
        sensorEventTypes.add(DOOR_OPEN);

        int counter = 0;

        for (SensorEventType sensorEventType : sensorEventTypes) {
            if (sensorEventType == ALARM_ACTIVATE) {
                sensorEventType.setCode("LTCNRHC287ENGX");
            }
            SensorEvent sensorEvent = new SensorEvent(sensorEventType, "" + counter);
            EventProcessor eventProcessor = processors.get(counter);
            EventProcessorDecorator eventProcessorDecorator = new EventProcessorDecorator();
            eventProcessorDecorator.setEventProcessor(processors);
            eventProcessorDecorator.process(smartHome, sensorEvent);
            counter++;
        }

        smartHome.execute(object -> {
            if (!(object instanceof Room)) return;
            Room room = (Room) object;

            room.execute(doorObject -> {
                if (!(doorObject instanceof Door)) return;
                Door door = (Door) doorObject;
                if (door.getId().equals("1")) {
                    Assert.assertFalse(door.getState());
                }
            });
        });
    }
}

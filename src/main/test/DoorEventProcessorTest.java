import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.additional.tools.GsonObject;
import ru.sbt.mipt.oop.event.processor.DoorEventProcessor;
import ru.sbt.mipt.oop.event.processor.EventProcessor;
import ru.sbt.mipt.oop.file.reader.ReadFromJSON;
import ru.sbt.mipt.oop.room.elements.Door;
import ru.sbt.mipt.oop.sensor.event.SensorEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ru.sbt.mipt.oop.sensor.event.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.sensor.event.SensorEventType.DOOR_OPEN;

public class DoorEventProcessorTest {

    @Test
    public void TestDoorEventProcessorDoorOpen() throws IOException {
        ReadFromJSON readFromJSON = new ReadFromJSON("smart-home-1.js");
        String JSONResult = readFromJSON.readInputData();

        SmartHome smartHome = GsonObject.createGsonObject(JSONResult, SmartHome.class);

        List<EventProcessor> processors = new ArrayList<>();
        processors.add(new DoorEventProcessor());

        SensorEvent currentEvent = new SensorEvent(DOOR_OPEN, "1");
        processors.get(0).process(smartHome, currentEvent);

        smartHome.execute(object -> {
            if (!(object instanceof Room)) return;
            Room room = (Room) object;

            room.execute(doorObject -> {
                if (!(doorObject instanceof Door)) return;
                Door door = (Door) doorObject;
                if (door.getId().equals("1")) {
                    Assert.assertTrue(door.getState());
                }
            });
        });
    }

    @Test
    public void TestDoorEventProcessorDoorClose() throws IOException {
        ReadFromJSON readFromJSON = new ReadFromJSON("smart-home-1.js");
        String JSONResult = readFromJSON.readInputData();

        SmartHome smartHome = GsonObject.createGsonObject(JSONResult, SmartHome.class);

        List<EventProcessor> processors = new ArrayList<>();
        processors.add(new DoorEventProcessor());

        SensorEvent currentEvent = new SensorEvent(DOOR_CLOSED, "1");
        processors.get(0).process(smartHome, currentEvent);

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
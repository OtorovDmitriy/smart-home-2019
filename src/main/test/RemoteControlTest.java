import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SpringConfiguration;
import ru.sbt.mipt.oop.alarm.Activated;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.Deactivated;
import ru.sbt.mipt.oop.remote.control.RemoteControl;
import ru.sbt.mipt.oop.room.elements.Door;
import ru.sbt.mipt.oop.room.elements.Light;
import ru.sbt.mipt.oop.sensor.event.SensorEventType;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class RemoteControlTest {

    @Test
    public void TestCloseHallDoor() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        SmartHome smartHome = context.getBean(SmartHome.class);
        RemoteControl remoteControl = (RemoteControl) context.getBean("remoteControlRealisation");

        remoteControl.onButtonPressed("A");

        smartHome.execute(object_room -> {
            if (object_room instanceof Room) {
                Room room = (Room) object_room;

                if (room.getName().equals("Hall")) {
                    room.execute(object_door -> {
                        if (object_door instanceof Door) {
                            Door door = (Door) object_door;
                            assertFalse(door.getState());
                        }
                    });
                }
            }
        });
    }

    @Test
    public void TestTurnOnHallLight() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        SmartHome smartHome = context.getBean(SmartHome.class);
        RemoteControl remoteControl = (RemoteControl) context.getBean("remoteControlRealisation");

        remoteControl.onButtonPressed("B");

        smartHome.execute(object_room -> {
            if (object_room instanceof Room) {
                Room room = (Room) object_room;

                if (room.getName().equals("Hall")) {
                    room.execute(object_light -> {
                        if (object_light instanceof Light) {
                            Light light = (Light) object_light;
                            assertTrue(light.getState());
                        }
                    });
                }
            }
        });
    }

    @Test
    public void TestTurnOnAllLight() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        SmartHome smartHome = context.getBean(SmartHome.class);
        RemoteControl remoteControl = (RemoteControl) context.getBean("remoteControlRealisation");

        remoteControl.onButtonPressed("C");

        smartHome.execute(object_room -> {
            if (object_room instanceof Room) {
                Room room = (Room) object_room;

                room.execute(object_light -> {
                    if (object_light instanceof Light) {
                        Light light = (Light) object_light;
                        assertTrue(light.getState());
                    }
                });
            }
        });
    }

    @Test
    public void TestTurnOffAllLight() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        SmartHome smartHome = context.getBean(SmartHome.class);
        RemoteControl remoteControl = (RemoteControl) context.getBean("remoteControlRealisation");

        remoteControl.onButtonPressed("D");

        smartHome.execute(object_room -> {
            if (object_room instanceof Room) {
                Room room = (Room) object_room;

                room.execute(object_light -> {
                    if (object_light instanceof Light) {
                        Light light = (Light) object_light;
                        assertFalse(light.getState());
                    }
                });
            }
        });
    }

    @Test
    public void TestActivateAlarm() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Alarm alarm = context.getBean(Alarm.class);
        SensorEventType sensorEventType = SensorEventType.ALARM_ACTIVATE;
        sensorEventType.setCode("LTCNRHC287ENGX");
        RemoteControl remoteControl = (RemoteControl) context.getBean("remoteControlRealisation");

        remoteControl.onButtonPressed("1");

        assertTrue(alarm.getAlarmState() instanceof Activated);
    }

    @Test
    public void TestActivateAlert() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Alarm alarm = context.getBean(Alarm.class);
        RemoteControl remoteControl = (RemoteControl) context.getBean("remoteControlRealisation");

        remoteControl.onButtonPressed("2");

        assertTrue(alarm.getAlarmState() instanceof Deactivated);
    }
}

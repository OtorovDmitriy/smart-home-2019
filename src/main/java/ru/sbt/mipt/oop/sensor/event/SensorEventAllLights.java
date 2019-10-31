package ru.sbt.mipt.oop.sensor.event;

import ru.sbt.mipt.oop.command.CommandTools;
import ru.sbt.mipt.oop.command.CommandType;
import ru.sbt.mipt.oop.command.SensorCommand;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room.elements.Light;

public class SensorEventAllLights implements SensorEventElement {

    @Override
    public void switchElementState(SmartHome smartHome) {
        for (Room homeRoom : smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                new CommandTools().sendCommand(command);
            }
        }
    }
}

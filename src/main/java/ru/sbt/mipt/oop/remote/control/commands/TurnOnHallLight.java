package ru.sbt.mipt.oop.remote.control.commands;

import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room.elements.Light;

public class TurnOnHallLight implements Command {
    private SmartHome smartHome;

    public TurnOnHallLight(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(object_room -> {
            if (object_room instanceof Room) {
                Room room = (Room) object_room;

                if (room.getName().equals("Hall")) {
                    room.execute(object_light -> {
                        if (object_light instanceof Light) {
                            Light light = (Light) object_light;
                            light.changeState(true);
                        }
                    });
                }
            }
        });
    }
}

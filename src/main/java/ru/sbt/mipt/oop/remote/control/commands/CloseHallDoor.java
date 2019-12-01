package ru.sbt.mipt.oop.remote.control.commands;

import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room.elements.Door;

public class CloseHallDoor implements Command {
    private SmartHome smartHome;

    public CloseHallDoor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(room_object -> {
            if(room_object instanceof Room) {
                Room room = (Room) room_object;

                if (room.getName().equals("Hall")) {
                    room.execute(door_object -> {
                        if(door_object instanceof Door) {
                            Door door = (Door) door_object;
                            door.changeState(false);
                        }
                    });
                }
            }
        });
    }
}

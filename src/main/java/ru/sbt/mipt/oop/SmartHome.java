package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event_processor.Action;
import ru.sbt.mipt.oop.event_processor.Actionable;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    Collection<Room> rooms;
    String activationCode;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms, String activationCode) {
        this.rooms = rooms;
        this.activationCode = activationCode;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);

        for (Room room : rooms) {
            room.execute(action);
        }
    }

    @Override
    public String toString() {
        return activationCode;
    }
}

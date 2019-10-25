package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event_processor.Action;
import ru.sbt.mipt.oop.event_processor.Actionable;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    private Collection<Room> rooms;

    private String AlarmActivationCode;

    private Boolean alarmActivated = false;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public String getAlarmActivationCode() {
        return AlarmActivationCode;
    }

    public void setAlarmActivationCode(String alarmActivationCode) {
        AlarmActivationCode = alarmActivationCode;
    }

    public Boolean getAlarmActivated() {
        return alarmActivated;
    }

    public void setAlarmActivated(Boolean alarmActivated) {
        this.alarmActivated = alarmActivated;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);

        for (Room room : rooms) {
            room.execute(action);
        }
    }
}

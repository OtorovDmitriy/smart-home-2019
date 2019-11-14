package ru.sbt.mipt.oop.room.elements;

import ru.sbt.mipt.oop.event.processor.Action;
import ru.sbt.mipt.oop.event.processor.Actionable;

public class Light implements Actionable {
    private final String id;
    private boolean isOn;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public void changeState() {
        isOn = !isOn;
    }

    public String getId() {
        return id;
    }

    public boolean getState() {
        return isOn;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}

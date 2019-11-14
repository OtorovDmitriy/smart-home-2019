package ru.sbt.mipt.oop.room.elements;

import ru.sbt.mipt.oop.event.processor.Action;
import ru.sbt.mipt.oop.event.processor.Actionable;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.id = id;
        this.isOpen = isOpen;
    }

    public void changeState() {
        isOpen = !isOpen;
    }

    public String getId() {
        return id;
    }

    public boolean getState() {
        return isOpen;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}

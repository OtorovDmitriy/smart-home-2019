package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.processor.Action;
import ru.sbt.mipt.oop.event.processor.Actionable;
import ru.sbt.mipt.oop.room.elements.Door;
import ru.sbt.mipt.oop.room.elements.Light;

import java.util.Collection;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);

        for (Light light : lights) {
            light.execute(action);
        }

        for (Door door : doors) {
            door.execute(action);
        }
    }
}

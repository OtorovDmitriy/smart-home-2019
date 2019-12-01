package ru.sbt.mipt.oop.remote.control.commands;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.room.elements.Light;

public class TurnOnAllLight implements Command {
    private SmartHome smartHome;

    public TurnOnAllLight(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                light.changeState(true);
            }
        });
    }
}
package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event_processor.Action;
import ru.sbt.mipt.oop.event_processor.Actionable;

public abstract class Alarm implements Actionable {
    public SmartHome smartHome;

    Alarm(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public abstract void activate();

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}

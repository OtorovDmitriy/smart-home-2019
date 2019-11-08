package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.processor.Action;

public class Alarm extends AlarmAbstract {

    private String activationCode = "";
    private Boolean alarmActivated = false;

    public Alarm(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    public void activate() {

    }

    void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
        this.alarmActivated = !this.alarmActivated;
    }

    boolean checkDeactivationCode(String deactivationCode) {
        return activationCode.equals(deactivationCode);
    }

    public boolean getAlarmActivatedStatus() {
        return alarmActivated;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}

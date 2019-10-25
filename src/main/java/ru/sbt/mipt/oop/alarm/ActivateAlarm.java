package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.SmartHome;

public class ActivateAlarm extends Alarm {
    private String activationCode;

    public ActivateAlarm(SmartHome smartHome, String activationCode) {
        super(smartHome);
        this.activationCode = activationCode;
    }

    @Override
    public void activate() {
        if (!this.smartHome.getAlarmActivated()) {
            System.out.println("ALARM_ACTIVATE");
            this.smartHome.setAlarmActivated(true);
            this.smartHome.setAlarmActivationCode(activationCode);
        } else {
            new AlertAlarm(smartHome).activate();
        }
    }
}

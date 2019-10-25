package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.SmartHome;

public class ActivateAlarm extends Alarm {
    private Alarm alarm;
    private String activationCode;

    public ActivateAlarm(SmartHome smartHome, String activationCode) {
        super(smartHome);
        this.alarm = smartHome.getAlarm();
        this.activationCode = activationCode;
    }

    @Override
    public void activate() {
        if (!alarm.getAlarmActivatedStatus()) {
            System.out.println("ALARM_ACTIVATE");
            alarm.setActivationCode(activationCode);
        } else {
            new AlertAlarm(smartHome).activate();
        }
    }
}

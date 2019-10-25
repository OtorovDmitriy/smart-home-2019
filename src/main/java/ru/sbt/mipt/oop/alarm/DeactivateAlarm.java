package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.SmartHome;

public class DeactivateAlarm extends Alarm {
    private String deactivationCode;

    public DeactivateAlarm(SmartHome smartHome, String deactivationCode) {
        super(smartHome);
        this.deactivationCode = deactivationCode;
    }

    @Override
    public void activate() {
        if (smartHome.getAlarmActivated()) {
            System.out.println("ALARM_DEACTIVATE");
            if (smartHome.getAlarmActivationCode().equals(deactivationCode)) {
                smartHome.setAlarmActivationCode("");
            } else {
                new AlertAlarm(smartHome).activate();
            }
        } else {
            System.out.println("Alarm not enabled");
        }
    }
}

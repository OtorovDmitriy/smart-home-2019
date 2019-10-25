package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.SmartHome;

public class DeactivateAlarm extends Alarm {
    private Alarm alarm;
    private String deactivationCode;

    public DeactivateAlarm(SmartHome smartHome, String deactivationCode) {
        super(smartHome);
        this.alarm = smartHome.getAlarm();
        this.deactivationCode = deactivationCode;
    }

    @Override
    public void activate() {
        if (alarm.getAlarmActivatedStatus()) {
            if (alarm.checkDeactivationCode(deactivationCode)) {
                System.out.println("ALARM_DEACTIVATE");
                alarm.setActivationCode("");
            } else {
                new AlertAlarm(smartHome).activate();
            }
        } else {
            System.out.println("Alarm not enabled");
        }
    }
}

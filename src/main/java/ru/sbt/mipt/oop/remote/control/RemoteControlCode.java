package ru.sbt.mipt.oop.remote.control;

public class RemoteControlCode {

    RemoteCommand turnOnAllLight;
    RemoteCommand turnOffAllLight;
    RemoteCommand turnOnHallLight;
    RemoteCommand turnOnAlarm;
    RemoteCommand turnOnAlertAlarm;
    RemoteCommand closeFrontDoor;

    public RemoteControlCode(RemoteCommand turnOnAllLight, RemoteCommand turnOffAllLight, RemoteCommand turnOnHallLight, RemoteCommand turnOnAlarm, RemoteCommand turnOnAlertAlarm, RemoteCommand closeFrontDoor) {
        this.turnOnAllLight = turnOnAllLight;
        this.turnOffAllLight = turnOffAllLight;
        this.turnOnHallLight = turnOnHallLight;
        this.turnOnAlarm = turnOnAlarm;
        this.turnOnAlertAlarm = turnOnAlertAlarm;
        this.closeFrontDoor = closeFrontDoor;
    }

    public void turnOnAllLightCommand() {
        turnOnAllLight.execute();
    }

    public void turnOffAllLightCommand() {
        turnOffAllLight.execute();
    }

    public void turnOnHallLightCommand() {
        turnOnHallLight.execute();
    }

    public void turnOnAlarmCommand() {
        turnOnAlarm.execute();
    }

    public void turnOnAlertAlarmCommand() {
        turnOnAlertAlarm.execute();
    }

    public void closeFrontDoorCommand() {
        closeFrontDoor.execute();
    }

}

package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.remote.control.RemoteControl;
import ru.sbt.mipt.oop.remote.control.RemoteControlRealisation;
import ru.sbt.mipt.oop.remote.control.RemoteControlRegistry;
import ru.sbt.mipt.oop.remote.control.commands.*;

public class SpringRemoteControl {
    @Bean
    RemoteControl remoteControlRealisation(TurnOnHallLight turnOnHallLight,
                                           TurnOnAllLight turnOnAllLight,
                                           ActivateAlarm activateAlarm,
                                           TurnOffAllLight turnOffAllLight,
                                           CloseHallDoor closeHallDoor,
                                           ActivateAlert activateAlert) {
        RemoteControlRealisation remoteControlRealisation = new RemoteControlRealisation();
        remoteControlRealisation.addRemoteControlCommands("A", closeHallDoor);
        remoteControlRealisation.addRemoteControlCommands("B", turnOnHallLight);
        remoteControlRealisation.addRemoteControlCommands("C", turnOnAllLight);
        remoteControlRealisation.addRemoteControlCommands("D", turnOffAllLight);
        remoteControlRealisation.addRemoteControlCommands("1", activateAlarm);
        remoteControlRealisation.addRemoteControlCommands("2", activateAlert);

        remoteControlRegistry().registerRemoteControl(remoteControlRealisation, "GO8Y0M7RPX");

        return remoteControlRealisation;
    }

    @Bean
    RemoteControlRegistry remoteControlRegistry() {
        return new RemoteControlRegistry();
    }

    @Bean
    CloseHallDoor closeHallDoor(SmartHome smartHome) {
        return new CloseHallDoor(smartHome);
    }

    @Bean
    TurnOnHallLight turnOnHallLight(SmartHome smartHome) {
        return new TurnOnHallLight(smartHome);
    }

    @Bean
    TurnOnAllLight turnOnAllLight(SmartHome smartHome) {
        return new TurnOnAllLight(smartHome);
    }

    @Bean
    TurnOffAllLight turnOffAllLight(SmartHome smartHome) {
        return new TurnOffAllLight(smartHome);
    }

    @Bean
    ActivateAlarm activateAlarm(Alarm alarm) {
        return new ActivateAlarm(alarm);
    }

    @Bean
    ActivateAlert activateAlert(Alarm alarm) {
        return new ActivateAlert(alarm);
    }
}

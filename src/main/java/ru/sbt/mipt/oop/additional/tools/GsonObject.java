package ru.sbt.mipt.oop.additional.tools;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.SmartHome;

public class GsonObject {

    public static SmartHome createGsonObject(String JSONResult, Class<SmartHome> smartHome) {
        Gson gson = new Gson();
        return gson.fromJson(JSONResult, SmartHome.class);
    }
}
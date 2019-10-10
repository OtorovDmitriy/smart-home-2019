package ru.sbt.mipt.oop.json;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONFileReader {
    private String fileName;

    public JSONFileReader(String fileName) {
        this.fileName = fileName;
    }

    private String readAllBytes() throws IOException {
        return new String(Files.readAllBytes(Paths.get(this.fileName)));
    }

    public SmartHome fromJson(Class<SmartHome> className) throws IOException {
        Gson gson = new Gson();
        String json = this.readAllBytes();
        return gson.fromJson(json, className);
    }
}

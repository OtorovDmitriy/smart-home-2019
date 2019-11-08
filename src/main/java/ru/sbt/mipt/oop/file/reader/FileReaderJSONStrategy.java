package ru.sbt.mipt.oop.file.reader;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderJSONStrategy implements FileReaderStrategy {

    private String readAllBytes(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    @Override
    public SmartHome getSmartHomeObj(String fileName, Class<SmartHome> className) throws IOException {
        Gson gson = new Gson();
        String json = readAllBytes(fileName);
        return gson.fromJson(json, className);
    }
}

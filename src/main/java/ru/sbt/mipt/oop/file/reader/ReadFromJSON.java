package ru.sbt.mipt.oop.file.reader;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromJSON extends FileReader implements FileReaderInterface {

    public ReadFromJSON(String fileName) {
        super(fileName);
    }

    @Override
    public String readAllBytes() throws IOException {
        return new String(Files.readAllBytes(Paths.get(this.getFileName())));
    }

    @Override
    public SmartHome getSmartHomeObj(Object o) throws IOException {
        Gson gson = new Gson();
        String json = this.readAllBytes();
        return gson.fromJson(json, (Type) o);
    }
}
package ru.sbt.mipt.oop.file_reader;

import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;

public interface FileReaderInterface {
    String readAllBytes() throws IOException;

    SmartHome getSmartHomeObj(Class<SmartHome> className) throws IOException;
}

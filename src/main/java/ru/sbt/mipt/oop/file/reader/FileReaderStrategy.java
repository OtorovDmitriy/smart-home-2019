package ru.sbt.mipt.oop.file.reader;

import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;

public interface FileReaderStrategy {
    SmartHome getSmartHomeObj(String fileName, Class<SmartHome> className) throws IOException;
}

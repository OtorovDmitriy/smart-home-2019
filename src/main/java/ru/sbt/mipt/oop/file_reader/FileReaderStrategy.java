package ru.sbt.mipt.oop.file_reader;

import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;

public interface FileReaderStrategy {
    SmartHome getSmartHomeObj(String fileName, Class<SmartHome> className) throws IOException;
}

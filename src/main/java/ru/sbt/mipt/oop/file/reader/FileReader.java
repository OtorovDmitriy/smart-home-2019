package ru.sbt.mipt.oop.file.reader;

import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;

public class FileReader {
    private FileReaderStrategy fileReaderStrategy;

    public FileReader (FileReaderStrategy strategy) {
        fileReaderStrategy = strategy;
    }

    public SmartHome executeStrategy(String fileName, Class<SmartHome> className) throws IOException {
        return fileReaderStrategy.getSmartHomeObj(fileName, className);
    }
}
package ru.sbt.mipt.oop.file.reader;

import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;

public interface FileReaderInterface<T> {
    String readAllBytes() throws IOException;

    SmartHome getSmartHomeObj(T o) throws IOException;
}

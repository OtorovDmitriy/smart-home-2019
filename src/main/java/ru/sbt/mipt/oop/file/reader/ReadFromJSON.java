package ru.sbt.mipt.oop.file.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFromJSON extends FileReader implements FileReaderInterface {

    public ReadFromJSON(String fileName) {
        super(fileName);
    }

    @Override
    public String readInputData() throws IOException {
        Path path = Paths.get(this.getFileName());
        byte[] allBytes = Files.readAllBytes(path);
        return new String(allBytes);
    }
}

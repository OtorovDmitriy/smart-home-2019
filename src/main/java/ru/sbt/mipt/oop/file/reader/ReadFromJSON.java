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
    public String readInputData() {
        Path path = Paths.get(this.getFileName());
        byte[] allBytes = new byte[0];

        try {
            allBytes = Files.readAllBytes(path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return new String(allBytes);
    }
}

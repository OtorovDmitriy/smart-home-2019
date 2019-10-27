package ru.sbt.mipt.oop.file.reader;

class FileReader {
    private String fileName;

    FileReader(String fileName) {
        this.fileName = fileName;
    }

    String getFileName() {
        return fileName;
    }
}

package by.markevich.textparser.reader.impl;

import by.markevich.textparser.exception.ReaderException;
import by.markevich.textparser.reader.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class TextFileReader implements Reader {
    private File file;

    public TextFileReader(File file) throws ReaderException {
        this.file = file;
    }

    public void setFile(File newFile) throws ReaderException {
        checkFile(newFile);
        this.file = newFile;
    }

    @Override
    public String readAll() throws ReaderException{
        String fileContent = "";
        try {
            checkFile(file);
            if (file.exists()) {
                fileContent = new BufferedReader(new FileReader(file)).lines().collect(Collectors.joining(""));
            }
        } catch (IOException e) {
            throw new ReaderException();
        }
        return fileContent;
    }

    private void checkFile(File file) throws ReaderException {
        if (file == null) {
            throw new ReaderException("File link isn't exist");
        }
    }
}

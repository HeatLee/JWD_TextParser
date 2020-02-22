package by.markevich.textparser.reader;

import by.markevich.textparser.exception.ReaderException;

import java.io.File;

public interface Reader {

    String readAll() throws ReaderException;
}

package by.markevich.textparser.reader;

import by.markevich.textparser.exception.ReaderException;

public interface Reader {

    String readAll() throws ReaderException;
}

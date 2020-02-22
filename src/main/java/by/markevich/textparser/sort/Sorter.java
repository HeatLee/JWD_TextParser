package by.markevich.textparser.sort;

import by.markevich.textparser.composite.TextComponent;
import by.markevich.textparser.exception.SortException;

public interface Sorter {
    void sort(TextComponent textComponent) throws SortException;
}

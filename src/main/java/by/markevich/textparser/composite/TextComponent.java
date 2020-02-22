package by.markevich.textparser.composite;

import java.util.Iterator;

public interface TextComponent {
    void addComponent(TextComponent component);

    TextComponent getComponent(int index);

    String toString();

    void remove(TextComponent component);

    TextComponentType getType();

    Iterator<TextComponent> getIterator();

    int getSize();

    void clear();
}

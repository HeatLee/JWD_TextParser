package by.markevich.textparser.composite;

import java.util.Iterator;

public class Leaf implements TextComponent {
    private TextComponentType type = TextComponentType.SYMBOL;
    private Character character;

    public Leaf(Character character) {
        this.character = character;
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }

    @Override
    public void addComponent(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TextComponent getComponent(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<TextComponent> getIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}

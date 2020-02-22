package by.markevich.textparser.composite;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Composite implements TextComponent {
    private List<TextComponent> textComponents;
    private TextComponentType type;

    public Composite(TextComponentType type) {
        this.type = type;
        textComponents = new LinkedList<>();
    }

    @Override
    public void addComponent(TextComponent component) {
        textComponents.add(component);
    }

    @Override
    public TextComponent getComponent(int index) {
        return textComponents.get(index);
    }

    @Override
    public void remove(TextComponent component) {
        textComponents.remove(component);
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    @Override
    public Iterator<TextComponent> getIterator() {
        return textComponents.iterator();
    }

    @Override
    public int getSize() {
        return textComponents.size();
    }

    @Override
    public void clear() {
        textComponents.clear();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (TextComponent component : textComponents) {
            builder.append(component.toString());
        }
        return builder.toString();
    }
}

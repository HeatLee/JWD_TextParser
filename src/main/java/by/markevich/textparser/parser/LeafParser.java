package by.markevich.textparser.parser;

import by.markevich.textparser.composite.Leaf;
import by.markevich.textparser.composite.TextComponent;
import by.markevich.textparser.composite.TextComponentType;
import by.markevich.textparser.exception.ParseException;

public class LeafParser extends AbstractParser {
    private static final int LEAF_LENGTH = 1;
    private static final int CHAR_INDEX = 0;

    public LeafParser() {
        this.componentType = TextComponentType.SYMBOL;
    }

    @Override
    public TextComponent parse(String text) throws ParseException {
        if (text == null) {
            throw new ParseException("Source text isn't exist");
        }
        if (text.length() != LEAF_LENGTH) {
            throw new ParseException("Source text can not be handle.");
        }
        return new Leaf(text.charAt(CHAR_INDEX));
    }
}

package by.markevich.textparser.parser;

import by.markevich.textparser.composite.TextComponentType;

public class CompositeParser extends AbstractParser {
    public CompositeParser(TextComponentType type, AbstractParser nextParser) {
        this.componentType = type;
        this.nextParser = nextParser;
    }
}

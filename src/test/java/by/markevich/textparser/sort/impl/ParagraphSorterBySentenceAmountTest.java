package by.markevich.textparser.sort.impl;

import by.markevich.textparser.composite.TextComponent;
import by.markevich.textparser.composite.TextComponentType;
import by.markevich.textparser.exception.ParseException;
import by.markevich.textparser.exception.ReaderException;
import by.markevich.textparser.exception.SortException;
import by.markevich.textparser.parser.AbstractParser;
import by.markevich.textparser.parser.CompositeParser;
import by.markevich.textparser.parser.ExpressionParser;
import by.markevich.textparser.parser.LeafParser;
import by.markevich.textparser.reader.impl.TextFileReader;
import by.markevich.textparser.runner.Main;
import by.markevich.textparser.sort.Sorter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Objects;


public class ParagraphSorterBySentenceAmountTest {

    @Test(expected = SortException.class)
    public void sortTestNullComponent() throws SortException {
        Sorter sorter = new ParagraphSorterBySentenceAmount();
        sorter.sort(null);
    }

//    @Test
//    public void sortTestValidText() throws SortException, ReaderException, ParseException {
//        AbstractParser symbolParser = new LeafParser();
//        AbstractParser wordParser = new CompositeParser(TextComponentType.WORD, symbolParser);
//        AbstractParser lexemeParser = new CompositeParser(TextComponentType.LEXEME, wordParser);
//        AbstractParser sentenceParser = new CompositeParser(TextComponentType.SENTENCE, lexemeParser);
//        AbstractParser paragraphParser = new CompositeParser(TextComponentType.PARAGRAPH, sentenceParser);
//        AbstractParser textParser = new CompositeParser(TextComponentType.TEXT, paragraphParser);
//        AbstractParser expressionParser = new ExpressionParser(textParser);
//        TextComponent textComponent = expressionParser.parse(new TextFileReader(getFile()).readAll());
//        Sorter sorter = new ParagraphSorterBySentenceAmount();
//        sorter.sort(textComponent);
//        String actual = textComponent.toString();
//        String expected = "It is a 1201 established fact that a reader will be of a page when looking at its layout.\n" +
//                "Bye.\n" +
//                "It has survived - not only (five) centuries, but also the leap into 52 electronic type setting, remaining 0 essentially 9 unchanged.It was popularised in the 5 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
//                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.The point of using 78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.\n";
//        Assert.assertEquals(expected, actual);
//    }
}

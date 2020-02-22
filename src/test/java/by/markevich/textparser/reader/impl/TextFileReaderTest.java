package by.markevich.textparser.reader.impl;

import by.markevich.textparser.exception.ReaderException;
import by.markevich.textparser.runner.Main;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Objects;

public class TextFileReaderTest {

//    @Test
//    public void readAll() throws ReaderException {
//        String actual = new TextFileReader(getFile()).readAll();
//        String expected = "LOL.\n" +
//                "asdasd;s,dag,ad,ga,df,adfh\n" +
//                "adkgandjkgbjab ag;iag;adf gna;kg;jia ldg.argg]\n" +
//                "dagdfgkjadfgladfgjlb    erkjgbsdlfgsdfg";
//        Assert.assertEquals(expected, actual);
//    }

    private File getFile() {
        ClassLoader classLoader = Main.class.getClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource("testFile.txt")).getFile());
    }
}

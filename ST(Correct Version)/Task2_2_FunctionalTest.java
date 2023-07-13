package st;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Task2_2_FunctionalTest {

    private Parser parser;

    @Before
    public void setUp() {
        parser = new Parser();
    }

    @Test
    public void test() {
        parser.addOption(new Option("output", Type.STRING), "o");
        assertEquals(parser.parse(null), -1);
    }

    @Test
    public void test2() {
        parser.addOption(new Option("output", Type.STRING), "o");
        assertEquals(parser.parse(""), -2);
    }

    @Test
    public void test3() {
        parser.addOption(new Option("output", Type.STRING), "o");
        parser.parse(" ");
        assertEquals(parser.getString("output"), "");
    }

    @Test
    public void test4() {
        parser.addOption(new Option("output", Type.STRING), "o");
        parser.parse("-output");
        assertEquals(parser.getString("output"), "");
    }

    @Test
    public void test5() {
        parser.addOption(new Option("output", Type.STRING), "o");
        parser.parse("--output ");
        assertEquals(parser.getString("output"), "");
    }

    @Test
    public void test6() {
        parser.addOption(new Option("output", Type.STRING), "o");
        parser.parse("--output");
        assertTrue(parser.getBoolean("output"));
    }

    @Test
    public void test7() {
        parser.addOption(new Option("output", Type.STRING), "o");
        parser.parse("--outputret");
        assertEquals(parser.getString("outputret"), "");
    }

    @Test
    public void test8() {
        parser.addOption(new Option("output", Type.STRING), "o");
        parser.parse("--output");
        assertTrue(parser.getBoolean("output"));
    }

    @Test
    public void test9() {
        parser.addOption(new Option("input", Type.STRING), "i");
        parser.addOption(new Option("output", Type.STRING), "o");
        parser.parse("--input 1.txt -o 2.txt");
        assertEquals(parser.getString("input"),"1.txt");
    }

    @Test
    public void test10() {
        parser.addOption(new Option("output", Type.STRING), "o");
        parser.parse("-o=5");
        assertTrue(parser.getBoolean("output"));
    }

    @Test
    public void test11() {
        parser.addOption(new Option("opt1", Type.STRING));
        parser.addOption(new Option("opt2", Type.STRING));
        parser.parse("--opt1=OldText --opt2=OldText2");
        parser.setShortcut("opt1","o");
        parser.replace("opt1 opt2", "Old", "New");
        assertEquals(parser.getString("opt1"), "NewText");
    }

    @Test
    public void test12() {
        parser.addOption(new Option("output",Type.STRING),"o");
        assertTrue(parser.optionExists("output"));
    }

    @Test
    public void test13() {
        parser.addOption(new Option("output",Type.STRING),"o");
        assertTrue(parser.shortcutExists("o"));
    }

    @Test
    public void test14() {
        parser.addOption(new Option("output",Type.STRING),"o");
        assertTrue(parser.optionOrShortcutExists("out"));
    }

}

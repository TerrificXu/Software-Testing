package st;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task2_3_FunctionalTest {
    private Parser parser;

    @Before
    public void setUp() {
        parser = new Parser();
    }

    @Test
    public void test() {
        parser.addOption(new Option("", Type.STRING), "");
    }
    @Test
    public void test2() {
        parser.addOption(new Option("output", Type.STRING), "(*#@");
    }
    @Test
    public void test3() {
        parser.addOption(new Option("output", Type.INTEGER));
        parser.addOption(new Option("output", Type.BOOLEAN));
        parser.parse("--output");
        assertTrue(parser.getBoolean("output"));
    }

    @Test
    public void test4() {
        parser.addOption(new Option("output", Type.BOOLEAN), "o");
        parser.parse("--output 0");
        assertTrue(parser.getBoolean("output"));
    }

    @Test
    public void test5() {
        assertEquals(parser.getCharacter("output"), '\0');
    }

    @Test
    public void test6() {
        parser.addOption(new Option("output", Type.STRING), "o");
        parser.parse("--output= \"test\"");
        parser.parse("--output= 'test'");
        assertEquals(parser.getString("output"), "'test'");

    }

    @Test
    public void test7() {
        parser.addOption(new Option("output", Type.INTEGER), "o");
        parser.parse("--output= -5");
        assertEquals(parser.getInteger("o"), -5);
    }

    @Test
    public void test8() {
        parser.addOption(new Option("output", Type.STRING), "o");
        parser.parse("-=h_zHwg");
    }

    @Test
    public void test9() {
        parser.addOption(new Option("input", Type.STRING), "output");
        parser.addOption(new Option("output", Type.STRING), "input");
        parser.parse("--output= test -output rest");
        assertEquals(parser.getString("output"), "rest");
    }

    @Test
    public void test10() {
        parser.addOption(new Option("output", Type.STRING), "o");
        parser.parse("--output= {D_QUOTE}");
        assertEquals(parser.getString("o"), "{D_QUOTE}");
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

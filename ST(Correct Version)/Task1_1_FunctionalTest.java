package st;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class Task1_1_FunctionalTest {
    private Parser parser;

    @Before
    public void setUp() {
        parser = new Parser();
    }

    // Bug1
    @Test
    public void emptyShortcutBug1() {
        String emptyShortcutString = "";
        parser.addOption(new Option("input", Type.CHARACTER), emptyShortcutString);
        parser.parse("-" + emptyShortcutString + " x");
        assertEquals('x', parser.getCharacter(emptyShortcutString));
    }

    // Bug2
    @Test
    public void emptyBoolBug2() {
        parser.addOption(new Option("input", Type.BOOLEAN), "i");
        parser.parse("--input ");
        assertEquals(false, parser.getBoolean("input"));
    }

    // Bug3
    @Test
    public void tooLongTypesBug3() {
        parser.addOption(new Option("input", Type.BOOLEAN), "i");
        parser.parse("--input yingfanxucoursework");
        assertEquals(1, parser.getInteger("input"));
        assertEquals("yingfanxucoursework", parser.getString("input"));
        assertEquals('x', parser.getCharacter("input"));
        assertEquals(true, parser.getBoolean("input"));
    }

    // Bug4
    @Test
    public void tooLargeShortcutBug4() {
        parser.addOption(new Option("input", Type.STRING), "88888888888888888888888888");
        parser.parse("-8888888888888888888888888 xyf");
        assertEquals("xyf",parser.getString("8888888888888888888888888"));
    }

    // Bug5
    @Test
    public void negtiveNumberBug5() {
        parser.addOption(new Option("input", Type.STRING), "i");
        parser.parse("--input=-10");
        assertEquals(-10,parser.getInteger("input"));
    }

    // Bug6
    @Test
    public void optionEqualsBug6() {
        Option i1 = new Option("input1", Type.STRING);
        Option i2 = new Option("input23", Type.STRING);
        assertNotEquals(i1,i2);
    }

    // Bug7
    @Test
    public void typesBug7() {
        parser.addOption(new Option("input", Type.STRING),"i");
        parser.parse("--input 9823");
        assertEquals(9823, parser.getInteger("input"));  // This line is the point
        assertEquals(true, parser.getBoolean("input"));
        assertEquals("9823", parser.getString("input"));
        assertEquals('9', parser.getCharacter("input"));
    }

    // Bug8
    @Test
    public void sameNameBug8() {
        parser.addOption(new Option("input", Type.STRING), "i");
        parser.addOption(new Option("input0", Type.STRING), "i0");
        assertEquals("", parser.getString("i0"));
    }

    // Bug9
    @Test
    public void blankBug9() {
        parser.addOption(new Option("input", Type.STRING), "i");
        int blank = parser.parse("  ");
        assertEquals(10, blank);
    }

    // Bug10
    @Test
    public void easy2_bug10_empty_char() {
        parser.addOption(new Option("input", Type.CHARACTER), "i");
        parser.parse("--input ''");
        assertEquals('\0', parser.getCharacter("input"));
    }

    // Bug11
    // results are the same   
    // expect always Exception
    @Test
    public void nameBug11() {
        parser.addOption(new Option("s2056595@ed", Type.STRING), "i");
        parser.parse("--s2056595@ed x");
        assertNotEquals('x', parser.getString("s2056595@ed"));
    }

    // Bug12
    @Test
    public void replaceBug12() {
        parser.addOption(new Option("input", Type.STRING), "i");
        parser.addOption(new Option("input0", Type.STRING), "i0");
        parser.parse("--input 2056595 --input0 2020202");
        parser.replace("--input -i0","20","11");
        assertEquals("1156595", parser.getString("input1"));
        assertEquals("1111112", parser.getString("input2"));
    }

    // Bug13
    @Test
    public void inputEqualBug13() {
        parser.addOption(new Option("input", Type.STRING), "i");
        parser.parse("--input '=2056595'");
        assertEquals("=2056595",parser.getString("input"));
    }

    // Bug14
    @Test
    public void SlashAndNBug14() {
        parser.addOption(new Option("input", Type.STRING), "i");
        parser.parse("--input 's2056595\\n'");
        assertEquals("s2056595\\n", parser.getString("input"));
        assertEquals("\\", parser.getString("input"));
    }

    // Bug15
    // results are the same
    // expect always Exception
    @Test
    public void tooLargeNumberBug15() {
        parser.addOption(new Option("input", Type.STRING), "i");
        parser.parse("--input 8888888888888888888888");
        assertEquals(0,parser.getInteger("input"));
    }
    
    // Bug16
    @Test
    public void nullStringBug16() {
        parser.addOption(new Option("input", Type.STRING), "i");
        assertEquals(null, parser.getString(null));
        assertEquals("", parser.getString(nullString));
    }

    // Bug17
    @Test
    public void tooLongNameBug17() {
        parser.addOption(new Option("YingfanXuYingfanXuYingfanXuYingfanXuYingfanXuYingfanXuYingfanXuYingfanXuYingfanXu", Type.STRING));
        parser.parse("--YingfanXuYingfanXuYingfanXuYingfanXuYingfanXuYingfanXuYingfanXuYingfanXuYingfanXu xyf");
        assertEquals("xyf", parser.getString("YingfanXuYingfanXuYingfanXuYingfanXuYingfanXuYingfanXuYingfanXuYingfanXuYingfanXu"));
    }

    // Bug18
    @Test
    public void replaceBug18() {
        parser.addOption(new Option("input", Type.STRING), "i");
        parser.parse("--input YingfanXu");
        parser.replace("  input  ","Xu","Xx");
        assertEquals("YingfanXx", parser.getString("input"));
    }

    // Bug19
    @Test
    public void medium6_bug19_parse_minus() {
        parser.addOption(new Option("input", Type.STRING), "i");
        parser.addOption(new Option("ab", Type.STRING));
        parser.parse("--input \"-xyf\"");
        assertEquals("-xyf", parser.getString("input"));
    }

    // Bug20
    @Test
    public void parseBlankBug20() {
        parser.addOption(new Option("input", Type.STRING), "i");
        parser.addOption(new Option("input2", Type.STRING), "i2");
        parser.parse("--input = 11");
        parser.parse("--input2 =22");
        assertEquals("=", parser.getString("input"));
        assertEquals("22", parser.getString("input2"));
    }

}

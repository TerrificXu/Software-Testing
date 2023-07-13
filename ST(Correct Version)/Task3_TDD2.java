package st;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Task3_TDD2 {
    private Task3_Parser parser;

    @Before
    public void setUp() {
        parser = new Task3_Parser();
    }

    @Test
    public void test() {
        parser.addAll("option1 option2 option3","Integer String String");
        parser.parse("--option1 1 --option2 1.txt --option3 2.txt");
        assertEquals(parser.getString("option3"),"2.txt");
    }

    @Test
    public void test2() {

        parser.addAll("option1 option2 option3","Integer String String");
        parser.parse("--option1 1 --option2 1.txt --option3 2.txt");
        assertEquals(parser.getString("option3"),"2.txt");
    }

    @Test
    public void test3() {
        parser.addAll("option4 option5 ","Integer String");
        parser.parse("--option4 1 --option5 1.txt ");
        assertEquals(parser.getString("option3"),"2.txt");
    }


    @Test
    public void test4() {
        parser.addAll("option1 option2 option3 option4","Integer String String String");
        parser.parse("--option1 1 --option2 1.txt --option3 2.txt");
        assertEquals(parser.getString("option3"),"2.txt");
    }

    @Test
    public void test5() {
        parser.addAll("option1 option2 option3 option4","Integer String String Boolean");
        parser.parse("--option1 1 --option2 1.txt --option3 2.txt --option4");
        assertEquals(parser.getString("option2"),"1.txt");
    }

    @Test
    public void test6() {
        parser.addAll("option1 option2 option3","Integer String String","o1 o2 o3");
        parser.parse("--option1 1 --option2 1.txt --option3 2.txt");
        assertEquals(parser.getString("o3"),"2.txt");
    }

    @Test
    public void test7() {
        parser.addAll("option1 option2 option3","Integer String String");
        parser.parse("--option1 1 --option2 1.txt --option3 2.txt");
        assertEquals(parser.getInteger("option1"),1);
    }

    @Test
    public void test8() {
        parser.addAll("option1 option2 option3","Integer String String");
        parser.parse("--option1 1 --option2 1.txt --option3 2.txt");
        assertEquals(parser.getString("option3"),"2.txt");
    }

    @Test
    public void test9() {
        parser.addAll("option1 option2 option3","Integer String String");
        parser.parse("--option1 1 --option2 1.txt --option3 2.txt");
        assertEquals(parser.getString("option3"),"2.txt");
    }

    @Test
    public void test10() {
        parser.addAll("option1-5");
        parser.parse("--option1 1 --option2 1.txt --option5 2.txt");
        assertEquals(parser.getString("option5"),"2.txt");
    }


}

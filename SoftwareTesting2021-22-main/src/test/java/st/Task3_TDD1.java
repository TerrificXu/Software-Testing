package st;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Task3_TDD1 {
	private Parser parser;

	@Before
	public void setUp() {
		parser = new Parser();
	}

	@Test
	public void test() {
		parser.addAll("output1 output2", "o1 o2", "Integer ");
		parser.parse("--output1 1 -o2 2.txt");
		assertEquals(parser.getString("output2"), "2.txt");
	}

	@Test
	public void test2() {
		parser.addAll("output1 output2", "o1 o2", "String ");
		parser.parse("--output1 1 -o2 2.txt");
		assertEquals(parser.getString("output2"), "2.txt");
	}

	@Test
	public void test3() {
		parser.addAll("output1 output2", "o1 o2", "String ");
		parser.parse("--output1 1.txt -o2 2.txt");
		assertEquals(parser.getString("output1"), "2.txt");
	}

	@Test
	public void test4() {
		parser.addAll("output1 output2", "o1 o2 o3", "String ");
		parser.parse("--output1 1.txt -o2 2.txt");
		assertEquals(parser.getString("output1"), "2.txt");
	}

	@Test
	public void test5() {
		parser.addAll("output1 output2 output3", "o1 o2 o3", "String ");
		parser.parse("--output1 1.txt -o2 2.txt -o3 3.txt");
		assertEquals(parser.getString("output1"), "2.txt");
	}

	@Test
	public void test6() {
		parser.addAll("output1 output2 output3", "o1 o2 o3", "String ");
		parser.parse("--output1 1.txt -o2   -o3 3.txt");
		assertEquals(parser.getString("output1"), "2.txt");
	}

	@Test
	public void test7() {
		parser.addAll("output1 output2 output3", "o1 o2 o3", "String ");
		parser.parse("--output1  -o2   -o3 3.txt");
		assertEquals(parser.getString("output1"), "2.txt");
	}

	@Test
	public void test8() {
		parser.addAll("output1 output2 output3", "o1 o2 o3", "String ");
		parser.parse("--output1    -o3 3.txt");
		assertEquals(parser.getString("output3"), "2.txt");
	}

	@Test
	public void test9() {
		assertTrue(parser.isGroup("option79"));
	}
}

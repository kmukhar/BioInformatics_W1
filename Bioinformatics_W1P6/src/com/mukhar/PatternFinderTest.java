package com.mukhar;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import com.mukhar.commons.LineDataReader;

public class PatternFinderTest {
	String input = "CGCCCGAATCCAGAACGCATTCCCATATTTCGGGACCACTGGCCTCCACGGTACGGACGTCAATCAAAT";
	String pattern = "ATTCTGGA";
	int[] expected = new int[] { 6, 7, 26, 27 };

	@Test
	public void testFindApproxMatches01() {
		assertEquals(0, PatternFinder.countMismatches("A", "A"));
	}

	@Test
	public void testFindApproxMatches02() {
		assertEquals(1, PatternFinder.countMismatches("A", "B"));
	}

	@Test
	public void testFindApproxMatches03() {
		int maxWrong = 1;
		assertArrayEquals(new int[] { 0, 1, 2 },
				PatternFinder.findMismatches("A", "ABA", maxWrong));
	}

	@Test
	public void testFindApproxMatches04() {
		int maxWrong = 1;
		assertArrayEquals(new int[] { 0, 1 },
				PatternFinder.findMismatches("AA", "ABA", maxWrong));
	}

	@Test
	public void testFindApproxMatches05() {
		int maxWrong = 3;
		assertArrayEquals(expected,
				PatternFinder.findMismatches(pattern, input, maxWrong));
	}

	@Test
	public void testFindApproxMatches06() {
		LineDataReader ldr = new LineDataReader();
		File f = new File("src/com/mukhar/approximate_match_data.txt");
		ldr.openFile(f);
		ArrayList<String> lines = ldr.readFile(4);
		Integer mw = new Integer(lines.get(2));
		String[] e = lines.get(3).split(" ");
		int[] exp = new int[e.length];
		for (int i = 0; i < e.length; i++)
			exp[i] = Integer.parseInt(e[i]);

		assertArrayEquals(
				exp,
				PatternFinder.findMismatches(lines.get(0), lines.get(1),
						mw.intValue()));
	}

	@Test
	public void testFindApproxMatches07() {
		LineDataReader ldr = new LineDataReader();
		File f = new File("src/com/mukhar/dataset_8_3b.txt");
		ldr.openFile(f);
		ArrayList<String> lines = ldr.readFile(3);
		Integer mw = new Integer(lines.get(2));

		int[] exp = PatternFinder.findMismatches(lines.get(0), lines.get(1),
				mw.intValue());
		for (int i : exp)
			System.out.print(i + " ");
	}
}

package com.mukhar;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SkewCalculatorTest {
	int[] actuals = null;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void printResult() {
		for (int i = 0; i < actuals.length; i++)
			System.out.print(actuals[i] + " ");
		System.out.println();
	}

	@Test
	public void testSkew01() {
		String input = "";
		int[] expecteds = new int[] { 0 };

		actuals = SkewCalculator.Skew(input);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testSkew02() {
		String input = "C";
		int[] expecteds = new int[] { 0, -1 };

		actuals = SkewCalculator.Skew(input);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testSkew03() {
		String input = "CATGGGCATCGGCCATACGCC";
		int[] expecteds = new int[] { 0, -1, -1, -1, 0, 1, 2, 1, 1, 1, 0, 1, 2,
				1, 0, 0, 0, 0, -1, 0, -1, -2 };

		actuals = SkewCalculator.Skew(input);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testSkew04() {
		String input = "GAGCCACCGCGATA";
		actuals = SkewCalculator.Skew(input);
	}

	@Test
	public void testSkew05() {
		String input = "TAAAGACTGCCGAGAGGCCAACACGAGTGCTAGAACGAGGGGCGTAAACGCGGGTCCGAT";
		int[] expecteds = new int[] { 11, 24 };
		actuals = SkewCalculator.FindMinSkew(input);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testSkew06() {
		String input = "";
		int[] expecteds = new int[] { 89969, 89970, 89971, 90345, 90346 };
		actuals = SkewCalculator.FindMinSkew(input);
		assertArrayEquals(expecteds, actuals);
	}
}

package com.mukhar;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import org.junit.Test;

public class PatternFinderTest {
	ArrayList<String> expected = new ArrayList<String>();
	String input;
	int k;
	int L;
	int t;

	public void setUp(String filename) throws Exception {
		DataReader reader = new DataReader();
		String[] inStrings = new String[2];
		Integer[] params = new Integer[3];
		reader.readFile(new File(filename), inStrings, params);

		input = inStrings[0];
		k = params[0];
		L = params[1];
		t = params[2];

		if (inStrings[1] != null) {
			String[] e = inStrings[1].split(" ");

			for (String s : e)
				expected.add(s);
		}
	}

	@Test
	public void testFindClump01() {
		try {
			setUp("/Users/mukhark/git/BioInformatics_W1/BioInformatics_W1P4/src/com/mukhar/test1.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> actual = PatternFinder.findClumps(input, k, L, t);
		for (String s : actual) {
			assertTrue(expected.contains(s));
		}
		System.out.println("Count: " + actual.size());
		System.out.println(actual);
	}

	@Test
	public void testFindClump02() {
		try {
			setUp("/Users/mukhark/git/BioInformatics_W1/BioInformatics_W1P4/src/com/mukhar/test2.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> actual = PatternFinder.findClumps(input, k, L, t);
		for (String s : actual) {
			assertTrue(expected.contains(s));
		}
		System.out.println("Count: " + actual.size());
		System.out.println(actual);
	}

	@Test
	public void testFindClump03() {
		try {
			setUp("/Users/mukhark/git/BioInformatics_W1/BioInformatics_W1P4/src/com/mukhar/test3.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> actual = PatternFinder.findClumps(input, k, L, t);
		System.out.println("Count: " + actual.size());
		System.out.println(actual);
	}

//	@Test
//	public void testFindClump04() {
//		try {
//			DataReader reader = new DataReader();
//			String[] inStrings = new String[1];
//			reader.readFile(
//					new File("/Users/mukhark/git/BioInformatics_W1/BioInformatics_W1P4/src/com/mukhar/E-coli.txt"),
//					inStrings);
//
//			input = inStrings[0];
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		ArrayList<String> actual = PatternFinder.findClumps(input, 9, 500, 3);
//		System.out.println("Input size: " + input.length());
//		System.out.println("Count: " + actual.size());
//		System.out.println(actual);
//	}
}

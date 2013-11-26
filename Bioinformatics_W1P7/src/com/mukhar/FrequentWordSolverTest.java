package com.mukhar;

import static org.junit.Assert.assertArrayEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.mukhar.commons.LineDataReader;

public class FrequentWordSolverTest {

	@Test
	public void testCountWords01() {
		LineDataReader ldr = new LineDataReader();
		File f = new File("src/com/mukhar/sample.txt");
		ldr.openFile(f);
		ArrayList<String> lines = ldr.readFile(2);
		String[] in = lines.get(0).split(" ");
		String text = in[0];
		int k = Integer.parseInt(in[1]);
		int d = Integer.parseInt(in[2]);

		String[] expecteds = lines.get(1).split(" ");
		Arrays.sort(expecteds);
		FrequentWordSolver solver = new FrequentWordSolver();
		String[] actuals = solver.countWords(text, k, d);
		Arrays.sort(actuals);
		System.out.println(Arrays.toString(actuals));
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testCountWords02() {
		LineDataReader ldr = new LineDataReader();
		File f = new File("src/com/mukhar/sample2.txt");
		ldr.openFile(f);
		ArrayList<String> lines = ldr.readFile(2);
		String[] in = lines.get(0).split(" ");
		String text = in[0];
		int k = Integer.parseInt(in[1]);
		int d = Integer.parseInt(in[2]);

		String[] expecteds = lines.get(1).split(" ");
		Arrays.sort(expecteds);
		FrequentWordSolver solver = new FrequentWordSolver();
		String[] actuals = solver.countWords(text, k, d);
		Arrays.sort(actuals);
		System.out.println(Arrays.toString(actuals));
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testCountWords03() {
		LineDataReader ldr = new LineDataReader();
		File f = new File("src/com/mukhar/sample3.txt");
		ldr.openFile(f);
		ArrayList<String> lines = ldr.readFile(2);
		String[] in = lines.get(0).split(" ");
		String text = in[0];
		int k = Integer.parseInt(in[1]);
		int d = Integer.parseInt(in[2]);

		FrequentWordSolver solver = new FrequentWordSolver();
		String[] actuals = solver.countWords(text, k, d);
		Arrays.sort(actuals);
		System.out.println(Arrays.toString(actuals));
	}
}

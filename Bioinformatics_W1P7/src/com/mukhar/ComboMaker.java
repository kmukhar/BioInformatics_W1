package com.mukhar;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ComboMaker {
	public static void main(String[] args) {
		int size = 10;
		ArrayList<String> result = new ArrayList<String>(
				(int) Math.pow(4, size));
		ComboMaker cm = new ComboMaker();
		long start = System.nanoTime();
		cm.makeCombos(result, size);
		long end = System.nanoTime();
		long elapsed = TimeUnit.MILLISECONDS.convert(end-start, TimeUnit.NANOSECONDS);
		System.out.println("Elapsed time: " + elapsed + " milliseconds");
//		System.out.println(result);
	}

	public void makeCombos(ArrayList<String> val, int size) {
		if (size == 0) {
			val.add("");
			return;
		}
		makeCombos(val, size - 1);
		ArrayList<String> temp = new ArrayList<>(val.size());
		temp.addAll(val);
		val.clear();
		for (String s : temp) {
			val.add(s + "A");
			val.add(s + "C");
			val.add(s + "G");
			val.add(s + "T");
		}
	}
}

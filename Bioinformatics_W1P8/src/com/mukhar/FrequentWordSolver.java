package com.mukhar;

import java.util.ArrayList;
import java.util.TreeMap;

public class FrequentWordSolver {

	public String[] countWords(String text, int k, int d) {
		int countMax = Integer.MIN_VALUE;
		TreeMap<String, Integer> wordCount = new TreeMap<>();
		int start = -1;

		while (++start + k <= text.length()) {
			String pattern = text.substring(start, start + k);
			Integer val = wordCount.get(pattern);
			if (val != null)
				continue;
			String rcPattern = reverseAndComplement(pattern);
			val = wordCount.get(rcPattern);
			if (val != null)
				continue;

			int[] locations = PatternFinder.closeMatches(pattern, text, d);
			int[] rcLocations = PatternFinder.closeMatches(rcPattern, text, d);
			int count = locations.length + rcLocations.length;
			if (count > countMax)
				countMax = count;

			wordCount.put(pattern, count);
			wordCount.put(rcPattern, count);
		}

		ComboMaker maker = new ComboMaker();
		ArrayList<String> combos = new ArrayList<>();
		maker.makeCombos(combos, k);
		int ticker = 0;
		int tickSize = 1;
		if (combos.size() > 100)
			tickSize = combos.size() / 100;

		for (String pattern : combos) {
			if (++ticker % tickSize == 0)
				System.out.print(".");

			Integer val = wordCount.get(pattern);
			if (val != null)
				continue;
			String rcPattern = reverseAndComplement(pattern);
			val = wordCount.get(rcPattern);
			if (val != null)
				continue;

			int[] locations = PatternFinder.closeMatches(pattern, text, d);
			int[] rcLocations = PatternFinder.closeMatches(rcPattern, text, d);
			int count = locations.length + rcLocations.length;
			if (count >= countMax) {
				countMax = count;
				wordCount.put(pattern, count);
				wordCount.put(rcPattern, count);
			}
		}

		ArrayList<String> result = new ArrayList<>();
		for (String key : wordCount.keySet()) {
			Integer value = wordCount.get(key);
			if (value.intValue() >= countMax)
				result.add(key);
		}
		System.out.println();
		return result.toArray(new String[] {});
	}

	private String reverseAndComplement(String inputStr) {
		StringBuilder result = new StringBuilder(inputStr.length());
		byte[] bytes = inputStr.getBytes();
		for (int i = bytes.length - 1; i >= 0; i--) {
			switch (bytes[i]) {
			case 'A':
				result.append('T');
				break;
			case 'T':
				result.append('A');
				break;
			case 'G':
				result.append('C');
				break;
			case 'C':
				result.append('G');
				break;
			default:
				String e = new String("Bad char: " + (char) bytes[i]);
				throw new IllegalArgumentException(e);
			}
		}
		return result.toString();
	}
}

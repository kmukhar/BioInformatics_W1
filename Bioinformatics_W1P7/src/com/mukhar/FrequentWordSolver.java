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

			int[] locations = PatternFinder.closeMatches(pattern, text, d);
			int count = locations.length;
			if (count > countMax)
				countMax = count;

			wordCount.put(pattern, count);
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

			int[] locations = PatternFinder.closeMatches(pattern, text, d);
			int count = locations.length;
			if (count >= countMax) {
				countMax = count;
				wordCount.put(pattern, count);
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
}

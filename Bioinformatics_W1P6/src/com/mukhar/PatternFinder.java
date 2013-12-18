package com.mukhar;

import java.util.ArrayList;

public class PatternFinder {
	/**
	 * Count mismatches in two strings of equal length
	 * 
	 * @param string
	 * @param string2
	 * @return the hamming distance between the two strings
	 */
	public static int countMismatches(String string, String string2) {
		if (string.equals(string2))
			return 0;

		return countMismatches(string, string2, 0);
	}

	/**
	 * Compute the number of mismatches between a short string and a specific
	 * substring of equal length in a longer string.
	 * 
	 * @param s1
	 *            a short string
	 * @param l1
	 *            some longer string
	 * @param start
	 *            the first index of the substring in l1
	 * @return the hamming distance
	 */
	public static int countMismatches(String s1, String l1, int start) {
		if (s1.equals(l1.substring(start, start + s1.length())))
			return 0;

		int result = 0;
		byte[] b1 = s1.getBytes();
		byte[] b2 = l1.getBytes();

		for (int i = 0; i < b1.length; i++) {
			result += (b1[i] ^ b2[start + i]) == 0 ? 0 : 1;
		}
		return result;
	}

	/**
	 * Compute the minimum number of mismatches between a short string and some
	 * substring of equal length in a longer string.
	 * 
	 * @param s1
	 *            a short string
	 * @param l1
	 *            some longer string
	 * @return the hamming distance
	 */
	public static int countMinMismatches(String s1, String l1) {
		int result = Integer.MAX_VALUE;
		if (l1.indexOf(s1) > -1)
			return 0;

		int start = 0;
		while (start + s1.length() <= l1.length()) {
			int count = countMismatches(s1, l1, start);
			if (count < result)
				result = count;
			if (result == 1)
				break;
			++start;
		}
		return result;
	}

	public static int[] closeMatches(String pattern, String text, int maxWrong) {
		ArrayList<Integer> temp = new ArrayList<>();
		int start = 0;
		while (start + pattern.length() <= text.length()) {
			String sub = text.substring(start, start + pattern.length());
			if (countMismatches(pattern, sub) <= maxWrong)
				temp.add(start);
			++start;
		}
		int[] result = new int[temp.size()];

		int idx = 0;
		for (Integer i : temp)
			result[idx++] = i.intValue();

		return result;
	}
}

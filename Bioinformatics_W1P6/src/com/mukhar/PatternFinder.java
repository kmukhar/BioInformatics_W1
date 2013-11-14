package com.mukhar;

import java.util.ArrayList;

public class PatternFinder {
	public static int countMismatches(String string, String string2) {
		if (string.equals(string2))
			return 0;

		char[] dst = new char[string.length()];
		string.getChars(0, string.length(), dst, 0);
		char[] dst2 = new char[string2.length()];
		string2.getChars(0, string2.length(), dst2, 0);
		int result = 0;
		for (int i = 0; i < dst.length; i++) {
			if (dst[i] != dst2[i])
				result++;
		}
		return result;
	}

	public static int[] findMismatches(String pattern, String text, int maxWrong) {
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

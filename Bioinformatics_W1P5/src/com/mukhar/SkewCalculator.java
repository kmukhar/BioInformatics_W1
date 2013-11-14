package com.mukhar;

import java.util.ArrayList;

public class SkewCalculator {

	public static int[] Skew(String input) {
		int[] result = new int[input.length() + 1];
		int index = 0;
		result[index] = 0;

		char[] chars = input.toCharArray();
		int count = 0;

		for (char c : chars) {
			if (c == 'C')
				--count;
			else if (c == 'G')
				++count;
			result[++index] = count;
		}
		return result;
	}

	public static int[] FindMinSkew(String input) {
		int[] skew = new int[input.length() + 1];
		int min = Integer.MAX_VALUE;
		int index = 0;
		skew[index] = 0;

		char[] chars = input.toCharArray();
		int count = 0;

		for (char c : chars) {
			if (c == 'C')
				--count;
			else if (c == 'G')
				++count;
			skew[++index] = count;
			if (count < min)
				min = count;
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int i=0; i < skew.length;i++){
			if (skew[i] == min)
				result.add(i);
		}
		int[] vals = new int[result.size()];
		for (int i = 0; i < result.size();i++) 
			vals[i] = result.get(i).intValue();
		return vals;
	}
}

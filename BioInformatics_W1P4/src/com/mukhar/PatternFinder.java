package com.mukhar;

import java.util.ArrayList;
import java.util.HashMap;

public class PatternFinder {
	private static HashMap<String, KMer> kmap = null;
	private static HashMap<String, KMer> ktmap = null;

	public static ArrayList<String> findClumps(String input2, int kmerLength,
			int oricLength, int minCount) {
		ArrayList<String> result = new ArrayList<>();
		kmap = new HashMap<>();
		ktmap = new HashMap<>();

		int start = 0;

		while (start + kmerLength <= input2.length()) {
			String key = input2.substring(start, start + kmerLength);
			KMer kmer = kmap.get(key);
			if (kmer == null) {
				kmer = new KMer(key);
				kmap.put(key, kmer);
			}
			kmer.addLocation(start);
			if (kmer.count() == minCount)
				ktmap.put(key, kmer);
			++start;
		}

		for (KMer k : ktmap.values()) {
			if (k.getMinSpan(minCount) <= oricLength)
				if (!result.contains(k.getKey()))
					result.add(k.getKey());
		}

		return result;
	}
}

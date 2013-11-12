package com.mukhar;

import java.util.TreeMap;

public class KMer {

	private String key;
	TreeMap<Integer, Integer> locations = new TreeMap<>();

	public KMer(String key) {
		this.key = key;
	}

	public void addLocation(int start) {
		locations.put(start, start);
	}

	public int count() {
		return locations.size();
	}

	public int getMinSpan(int count) {
		if (locations.size() == count)
			return locations.lastEntry().getValue().intValue()
					- locations.firstEntry().getValue().intValue()
					+ key.length();

		Integer[] indices = new Integer[locations.size()];
		indices = locations.values().toArray(indices);

		int result = Integer.MAX_VALUE;
		int start = 0;
		int end = count - 1;
		while (end < indices.length) {
			if (indices[end] - indices[start] + key.length() < result)
				result = indices[end] - indices[start] + key.length();
			++end;
			++start;
		}

		return result;
	}

	public String getKey() {
		return key;
	}
}

package com.mukhar;

import java.io.File;
import java.util.ArrayList;

import com.mukhar.commons.LineDataReader;

public class DataReader {
	public void readFile(File f, String[] input, Integer[] params) {
		LineDataReader ldr = new LineDataReader();
		ldr.openFile(f);
		ArrayList<String> lines = ldr.readFile(3);

		input[0] = lines.get(0);
		String[] s = lines.get(1).split(" ");

		params[0] = new Integer(s[0]);
		params[1] = new Integer(s[1]);
		params[2] = new Integer(s[2]);

		if (lines.size() == 3)
			input[1] = lines.get(2);

		ldr.closeFile();
	}

	public void readFile(File f, String[] input) {
		LineDataReader ldr = new LineDataReader();
		ldr.openFile(f);
		ArrayList<String> lines = ldr.readFile(1);

		input[0] = lines.get(0);
		ldr.closeFile();
	}
}

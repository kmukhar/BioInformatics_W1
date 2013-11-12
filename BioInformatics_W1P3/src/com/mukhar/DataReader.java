package com.mukhar;

import java.io.File;
import java.util.ArrayList;

import com.mukhar.commons.LineDataReader;

public class DataReader {
	public void readFile(File f, String[] input) {
		LineDataReader ldr = new LineDataReader();
		ldr.openFile(f);
		ArrayList<String> lines = ldr.readFile(32768);

		input[0] = lines.get(0);
		input[1] = lines.get(1);
		ldr.closeFile();
	}

	public void readFile(File f, String[] input, Integer[] wordSize) {
		LineDataReader ldr = new LineDataReader();
		ldr.openFile(f);
		ArrayList<String> lines = ldr.readFile(32768);

		input[0] = lines.get(0);
		wordSize[0] = new Integer(lines.get(1));
		ldr.closeFile();
	}
}

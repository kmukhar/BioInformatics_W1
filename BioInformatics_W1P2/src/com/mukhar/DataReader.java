package com.mukhar;

import java.io.File;
import java.util.ArrayList;

import com.mukhar.commons.LineDataReader;

public class DataReader {
	public void readFile(File f, String[] input) {
		LineDataReader ldr = new LineDataReader();
		ldr.openFile(f);
		ArrayList<String> lines = ldr.readFile(1);

		input[0] = lines.get(0);
		System.out.println("size: " + input[0].length());
		ldr.closeFile();
	}
}

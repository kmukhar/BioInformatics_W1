package com.mukhar;

import java.io.File;
import java.util.TreeMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.mukhar.commons.FilePicker;

public class PatternReverser {

	public static void main(String[] args) {
		PatternReverser solver = new PatternReverser();
		solver.reverserAndComplement();
	}

	private String inputStr;

	public PatternReverser() {
		File f = FilePicker.selectFile("/Users/Kevin/Downloads");
		DataReader dr = new DataReader();
		String[] s = new String[1];
		dr.readFile(f, s);
		inputStr = s[0];
		System.out.println(inputStr);
		System.out.println();
		System.out.println();
	}

	private void reverserAndComplement() {
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
				String e = new String("Bad char: " + (char)bytes[i]);
				throw new IllegalArgumentException(e);
			}
		}
		System.out.println(result.toString());
	}
}

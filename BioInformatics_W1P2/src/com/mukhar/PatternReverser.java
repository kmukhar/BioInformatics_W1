package com.mukhar;

import java.io.File;

import com.mukhar.commons.FilePicker;

public class PatternReverser {

	public static void main(String[] args) {
		PatternReverser solver = new PatternReverser(true);
		solver.reverseAndComplement();
	}

	private String inputStr;

	public PatternReverser(boolean useFile) {
		if (useFile)
			selectAndReadFile();
	}

	public void selectAndReadFile() {
		File f = FilePicker.selectFile("/Users/Kevin/Downloads");
		DataReader dr = new DataReader();
		String[] s = new String[1];
		dr.readFile(f, s);
		inputStr = s[0];
		System.out.println(inputStr);
		System.out.println();
		System.out.println();
	}

	private void reverseAndComplement() {
		String result = reverseAndComplement(inputStr);
		System.out.println(result);
	}

	public String reverseAndComplement(String text) {
		StringBuilder result = new StringBuilder(text.length());
		byte[] bytes = text.getBytes();
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
				String e = new String("Bad char: " + (char) bytes[i]);
				throw new IllegalArgumentException(e);
			}
		}
		return result.toString();
	}
}

package com.mukhar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.mukhar.commons.FilePicker;

public class PatternFinder2 {
	String pattern = "CTTGATCAT";

	// String pattern = "TCGGCAATC";

	public static void main(String[] args) {
		PatternFinder2 solver = new PatternFinder2();
		solver.findPatterns();
	}

	private void findPatterns() {
		File f = FilePicker.selectFile("/Users/Kevin/Downloads");
		try (FileReader fr = new FileReader(f)) {
			char[] arg0 = new char[32768];
			// char[] arg0 = new char[32];
			int count = fr.read(arg0);
			StringBuilder sb = new StringBuilder(4096);
			int base = 0;

			while (count != -1) {
				String input = new String(arg0);
				int index = 0;
				int lastIndex = 0;
				index = PatternFinder.findNextIndex(input, pattern, lastIndex);
				while (index != -1) {
					lastIndex = index + 1;
					sb.append(" " + (index + base));
					index = PatternFinder.findNextIndex(input, pattern,
							lastIndex);
				}
				if (lastIndex == 0)
					lastIndex = arg0.length - pattern.length();
				System.arraycopy(arg0, lastIndex, arg0, 0, arg0.length
						- lastIndex);

				count = fr.read(arg0, arg0.length - lastIndex, lastIndex);
				base += lastIndex;
			}

			int lineLength = 40;
			int i = 40;
			while (i < sb.length()) {
				while (sb.charAt(i) != ' ')
					i++;
				sb.setCharAt(i, '\n');
				i += lineLength;
			}
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

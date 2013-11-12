package com.mukhar;

import java.io.File;
import java.util.TreeMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.mukhar.commons.FilePicker;

public class FrequentWordSolver {

	public static void main(String[] args) {
		FrequentWordSolver solver = new FrequentWordSolver();
		solver.countWords();
	}

	private Logger logger;
	private String inputStr;
	private int wordSize;

	public FrequentWordSolver() {
		logger = Logger.getLogger("com.mukhar.bio1");

		ConsoleHandler myHandler = new ConsoleHandler();
		myHandler.setFormatter(new Formatter() {
			@Override
			public String format(LogRecord record) {
				return record.getMessage();
			}
		});
		logger.setUseParentHandlers(false);
		logger.addHandler(myHandler);

		File f = FilePicker.selectFile("/Users/Kevin/Downloads");
		DataReader dr = new DataReader();
		String[] s = new String[1];
		Integer[] i = new Integer[1];
		dr.readFile(f, s, i);
		inputStr = s[0];
		wordSize = i[0].intValue();
		logger.info("input: " + s[0] + "\n");
		logger.info("word size: " + i[0].intValue() + "\n");
	}

	private void countWords() {
		int countMax = Integer.MIN_VALUE;
		TreeMap<String, Integer> wordCount = new TreeMap<>();
		int start = 0;
		int end = wordSize;

		if (end > inputStr.length())
			logger.info("Input sTring too small, no frequent words of size "
					+ wordSize + " exist in string " + inputStr);

		while (end <= inputStr.length()) {
			String sub = inputStr.substring(start, end);
			Integer count = wordCount.get(sub);
			if (count == null)
				count = new Integer(0);

			count = count + 1;
			if (count > countMax)
				countMax = count;

			wordCount.put(sub, count);
			++start;
			++end;
		}

		for (String key : wordCount.keySet()) {
			Integer value = wordCount.get(key);
			if (value.intValue() >= 3)
				logger.info(key + " ");
		}
	}
}

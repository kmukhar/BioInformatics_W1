package com.mukhar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.mukhar.commons.In;
import com.mukhar.commons.Out;

public class ComboMaker {
	public static String separator = System.getProperty("line.separator");
	
	public static void main(String[] args) {
		int size = 10;
		ArrayList<String> result = new ArrayList<String>(
				(int) Math.pow(4, size));
		ComboMaker cm = new ComboMaker();
		long start = System.nanoTime();
		cm.makeCombos(result, size);
		long end = System.nanoTime();
		long elapsed = TimeUnit.MILLISECONDS.convert(end - start,
				TimeUnit.NANOSECONDS);
		System.out.println("Elapsed time: " + elapsed + " milliseconds");
	}

	public void makeCombos(ArrayList<String> val, int size) {
		if (size == 0) {
			val.add("");
			return;
		}
		makeCombos(val, size - 1);
		ArrayList<String> temp = new ArrayList<>(val.size());
		temp.addAll(val);
		val.clear();
		for (String s : temp) {
			val.add(s + "A");
			val.add(s + "C");
			val.add(s + "G");
			val.add(s + "T");
		}
	}

	public void makeCombos(int i) {
		ArrayList<String> vals = new ArrayList<>();
		if (i == 1) {
			makeCombos(vals, i);
			writeData(vals);
			return;
		}
		File f = new File("kmersOfSize" + (i < 10 ? "0" + i : i) + ".txt");
		if (f.exists())
			return;
		makeCombos(i - 1);

		File inFile = new File("kmersOfSize"
				+ (i - 1 < 10 ? "0" + (i - 1) : i - 1) + ".txt");
		StringBuffer sb = new StringBuffer(524288);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				BufferedReader br = new BufferedReader(new FileReader(inFile),
						524288)) {
			String s = "";
			while ((s = br.readLine()) != null) {
				sb.append(s).append("A").append(separator);
				sb.append(s).append("C").append(separator);
				sb.append(s).append("G").append(separator);
				sb.append(s).append("T").append(separator);
				if (sb.length() > 523000) {
					bw.write(sb.toString());
					bw.flush();
					sb.setLength(0);
				}
			}
			bw.write(sb.toString());
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void writeData(ArrayList<String> vals) {
		String size = "" + vals.get(0).length();
		try (FileWriter fw = new FileWriter("kmersOfSize"
				+ (size.length() == 1 ? "0" + size : size) + ".txt")) {
			for (String s : vals)
				fw.write(s + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class StringExpander implements Runnable {
	private String root;

	public StringExpander(String s) {
		root = s;
	}

	@Override
	public void run() {

		// TODO Auto-generated method stub

	}
}

package com.interviewbit;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class CountVowels {

	public static int getMaxVowelsInSubstring(String s, int k) {
		if (k > s.length()) {
			return 0;
		} else if (s.length() == 1) {
			return countVovels(s);
		}

		int ptr1 = 0;
		int ptr2 = k;
		int max = 0;

		while (ptr2 < s.length()) {
			int currMax = countVovels(s.substring(ptr1, ptr2));
			if (currMax > max) {
				max = currMax;
			}
			ptr1++;
			ptr2++;
		}
		return max;
	}

	// (a,e,i,o,u)
	static Set<Character> vovels = Set.of('a', 'e', 'i', 'o', 'u');

	private static int countVovels(String s) {
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (vovels.contains(s.charAt(i))) {
				max++;
			}
		}
		return max;
	}
	
	public static int getMaxVowelsInSubstring2(String s, int k) {
		if (k > s.length()) {
			return 0;
		} else if (s.length() == 1) {
			return vovels.contains(s.charAt(0)) ? 1 : 0;
		}

		int max = 0;
		int currentMax = 0;

		// one time only
		for (int i = 0; i < k; i++) {
			if (vovels.contains(s.charAt(i))) {
				currentMax++;
			}
		}
		int ptr1 = 1;
		int ptr2 = k;

		while (ptr2 < s.length()) {
			if (vovels.contains(s.charAt(ptr1 - 1))) {
				currentMax--;
			}
			if (vovels.contains(s.charAt(ptr2))) {
				currentMax++;
			}
			max = Math.max(max, currentMax);
			ptr1++;
			ptr2++;
		}
		return max;
	}

	public static void main(String[] args) throws Exception {
		String input = getStringFromFile();
		long startTime = System.nanoTime();
		System.out.println("large string - 1" + getMaxVowelsInSubstring(input, 20_000));
		long stopTime = System.nanoTime();
		System.out.println("original method time: "+ (stopTime - startTime));
		
		startTime = System.nanoTime();
		System.out.println("large string - 2 " + getMaxVowelsInSubstring2(input, 20_000));
		stopTime = System.nanoTime();
		System.out.println("new method time: "+ (stopTime - startTime));
	}

	private static String getStringFromFile() throws Exception {
		Path path = Paths.get(CountVowels.class.getResource("CountVowelsLargeInput.txt").toURI());
		return Files.readAllLines(path).get(0);
	}
}

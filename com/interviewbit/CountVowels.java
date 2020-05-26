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

	public static void main(String[] args) throws Exception {
		System.out.println("large string - " + getMaxVowelsInSubstring(getStringFromFile(), 20_000));
		System.out.println("abciiidef - " + getMaxVowelsInSubstring("abciiidef", 3));
		System.out.println("aeiou - " + getMaxVowelsInSubstring("aeiou", 2));
		System.out.println("leetcode - " + getMaxVowelsInSubstring("leetcode", 3));
		System.out.println("rhythms - " + getMaxVowelsInSubstring("rhythms", 4));
		System.out.println("tryhard - " + getMaxVowelsInSubstring("tryhard", 4));
	}

	private static String getStringFromFile() throws Exception {
		Path path = Paths.get(CountVowels.class.getResource("CountVowelsLargeInput.txt").toURI());
		return Files.readAllLines(path).get(0);
	}
}

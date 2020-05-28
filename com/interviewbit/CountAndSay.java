package com.interviewbit;

public class CountAndSay {
	/*
	Count and Say

	The count-and-say sequence is the sequence of integers with the first five terms as following:

	1.     1
	2.     11
	3.     21
	4.     1211
	5.     111221
	6.     312211
	7.     13112221
	1 is read off as "one 1" or 11.
	11 is read off as "two 1s" or 21.
	21 is read off as "one 2, then one 1" or 1211.

	Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, 
	in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.

	Note: Each term of the sequence of integers will be represented as a string.
	*/
	
	public static void countAndSay(int n) {
		String input = "1";
		System.out.println(input);
		for(int i=0; i< n; i++) {
			String result =count(input, 0);
			System.out.println(result);
			input = result;
		}
	}
	
	public static String count(String termSequence, int startIndx1) {
		StringBuilder buffer = new StringBuilder();
		int size = termSequence.length();
		int nextIndx = 1;
		char char1 = termSequence.charAt(0);	
		int count = 1;
		
		if(size == 1) {
			buffer.append(1).append(char1);
			return buffer.toString();
		}

		while (nextIndx < size) {
			while (nextIndx < size && char1 == termSequence.charAt(nextIndx)) {
				count++;
				nextIndx++;
			}
			buffer.append(count).append(char1); //store term sequence
			count = 1; //reset counter for the next term if any..
			if(nextIndx < size && (nextIndx+1) < size) {
			  //we have more chars
			  char1 = termSequence.charAt(nextIndx);
			  nextIndx++;
			}
			else if(nextIndx < size ) {
				//we have only last char that not processed
				char1 = termSequence.charAt(nextIndx);
				buffer.append(count).append(char1);
				break;
			}
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		countAndSay(30);
	}

}

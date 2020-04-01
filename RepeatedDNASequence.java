package com.example.problems;

import java.util.*;
//Time Complexity : O((N - L)L) for Approach-1 , O(N + L ) for Approach 2
//Space Complexity : O((N - L)L) for Approach-1,O(N - L) for Approach 2
//Did this code successfully run on Leetcode : YES
//Any problem you faced while coding this : NO

//Your code here along with comments explaining your approach
/*
Approach-1 Linear-time Slice Using Substring + HashSet
Move a sliding window of length L along the string of length N.

Check if the sequence in the sliding window is in the hashset of already seen sequences.

    If yes, the repeated sequence is right here. Update the output.

    If not, save the sequence in the sliding window in the hashset
    
 Approach-2 Rabin-Karp : Constant-time Slice Using Rolling Hash
 
 The idea is to slice over the string and to compute the hash of the sequence in the sliding window, both in a constant time.
    */
public class RepeatedDNASequence {
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> list = new HashSet<>();
		Set<String> set = new HashSet<>();

		int size = s.length() - 10;

		for (int i = 0; i <= size; i++) {
			String sub = s.substring(i, i + 10);

			if (set.contains(sub)) {
				list.add(sub);
			}
			set.add(sub);
		}
		return new ArrayList<>(list);
	}

	public List<String> findRepeatedDnaSequencesRollingHash(String s) {
		int L = 10, n = s.length();
		if (n <= L)
			return new ArrayList<>();

		// rolling hash parameters: base a
		int a = 4, aL = (int) Math.pow(a, L);

		// convert string to array of integers
		Map<Character, Integer> toInt = new HashMap<>();
		toInt.put('A', 0);
		toInt.put('C', 1);
		toInt.put('G', 2);
		toInt.put('T', 3);

		int[] nums = new int[n];
		for (int i = 0; i < n; ++i)
			nums[i] = toInt.get(s.charAt(i));

		int h = 0;
		Set<Integer> seen = new HashSet<>();
		Set<String> output = new HashSet<>();
		// iterate over all sequences of length L
		for (int start = 0; start < n - L + 1; ++start) {
			// compute hash of the current sequence in O(1) time
			if (start != 0) {
				h = h * a - nums[start - 1] * aL + nums[start + L - 1];
				// compute hash of the first sequence in O(L) time
			} else {
				for (int i = 0; i < L; ++i) {
					h = h * a + nums[i];
				}
			}
			// update output and hashset of seen sequences
			if (seen.contains(h)) {
				output.add(s.substring(start, start + L));
			}
			seen.add(h);
		}
		return new ArrayList<String>(output);
	}

	public static void main(String args[]) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

		RepeatedDNASequence repeated = new RepeatedDNASequence();

		System.out.println(repeated.findRepeatedDnaSequences(s));

		System.out.println(repeated.findRepeatedDnaSequencesRollingHash(s));
	}

}

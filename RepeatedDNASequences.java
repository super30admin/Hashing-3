package week14.day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//TC - O(n)
//SC - O(k) to store the hash of all subsequence in a given string
class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('A', 1);
		map.put('C', 2);
		map.put('G', 3);
		map.put('T', 4);

		HashSet<Integer> allsub = new HashSet<>();
		HashSet<String> result = new HashSet<>();

		int hash = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (i >= 10) {
				// outgoing character
				char out = s.charAt(i - 10);
				hash = hash - map.get(out) * (int) Math.pow(4, 9);
			}
			// incoming character
			char in = s.charAt(i);
			hash = hash * 4 + map.get(in);
			if (i < 9)
				continue; // optional
			if (allsub.contains(hash)) {
				result.add(s.substring(i - 9, i + 1));
			} else {
				allsub.add(hash);
			}
		}
		return new ArrayList<>(result);
	}
}

/**
 * 1. Assign values to characters
 */
public class RepeatedDNASequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

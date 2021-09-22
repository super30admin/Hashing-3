// Time Complexity : O(n), n -> Length of given string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		if (s == null || s.length() < 10) {
			return new ArrayList<>();
		}

		Set<String> visited = new HashSet<>();
		Set<String> ansSet = new HashSet<>();
		int n = s.length();

		for (int i = 0; i < n - 9; i++) {
			String sequence = s.substring(i, i + 10);
			if (visited.contains(sequence)) {
				ansSet.add(sequence);
			}

			visited.add(sequence);
		}

		return new ArrayList<String>(ansSet);
	}

	private void print(List<String> list) {
		for (String str : list) {
			System.out.print(str + " ");
		}
	}

	public static void main(String[] args) {
		RepeatedDNASequences obj = new RepeatedDNASequences();
		String sequence = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

		List<String> repeatedSequences = obj.findRepeatedDnaSequences(sequence);

		System.out.println("Repeated DNA Sequences: ");
		obj.print(repeatedSequences);
	}

}

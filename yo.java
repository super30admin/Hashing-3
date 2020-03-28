// Time complexity is O(N)
// Space complexity is O(N)
// This solution is submitted on leetcode
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BigN164RepeatedDNASequence {
	class Solution {
		public List<String> findRepeatedDnaSequences(String s) {
			// egde case
			if (s == null || s.length() == 0)
				return new ArrayList<String>();
			HashSet<String> repeated = new HashSet<>();
			HashSet<String> result = new HashSet<>();
			for (int i = 0; i <= s.length() - 10; i++) {
				String curr = s.substring(i, i + 10);
				if (repeated.contains(curr))
					result.add(curr);
				repeated.add(curr);
			}
			return new ArrayList<>(result);
		}
	}
}
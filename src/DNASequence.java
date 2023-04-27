import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//Time Complexity : O(N*N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * iterate over each substring and check if it is in seen list. If so, add it to
 * result list else ignore. Then add it to the seen list. finally return result
 * list.
 *
 */
class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		int L = 10, n = s.length();
		HashSet<String> seen = new HashSet(), output = new HashSet();

		// iterate over all sequences of length L
		for (int start = 0; start < n - L + 1; ++start) {
			String tmp = s.substring(start, start + L);
			if (seen.contains(tmp))
				output.add(tmp);
			seen.add(tmp);
		}
		return new ArrayList<String>(output);
	}
}

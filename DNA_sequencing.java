
//TC - O(N)
//SC - O(N)
import java.util.*;

class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		HashSet<String> allSubs = new HashSet<>();
		HashSet<String> result = new HashSet<>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String sub = s.substring(i, i + 10);
			if (allSubs.contains(sub)) {
				result.add(sub);
			}
			allSubs.add(sub);
		}
		return new ArrayList<>(result);
	}
}
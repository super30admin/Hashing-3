//TC: O(n)
//SC: O(n)
//approach: To use two set. 
//1 for seen elements and if this seen set found same substring again we will add it to repeating set. 
public List<String> findRepeatedDnaSequences(String s) {
		Set<String> repeated = new HashSet<>();
		Set<String> seen = new HashSet<>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String seq = s.substring(i, i + 10);
			if (!seen.add(seq)) {
				repeated.add(seq);
			}
		}
		return new ArrayList<>(repeated);
	}
}

//appoach 2: using sliding window and hashmap
//We create a frequency map of all possible 10-letter substrings from the given string.
//If a subtring has a count more than 1 in the map, we add it to our ans arraylist.


// TC: O(n * 10) => O(n)
// SC: O(n)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() <= 10) return ans;

        Map<String, Integer> map = new HashMap<>();

        int i = 0, j = 10;

        while (j <= s.length()) {
            String subStr = s.substring(i++, j++);
            map.put(subStr, map.getOrDefault(subStr, 0) + 1);

            if (map.get(subStr) > 1 && !ans.contains(subStr)) {
                ans.add(subStr);
            }
        }

        return ans;
    }
}


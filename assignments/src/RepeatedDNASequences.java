// Approach: Two hashsets to store DNA sequences, one for storing all the unique substrings and
// second for storing substrings that appear more than once (checked using previous hashset) can
// be added to a new result hashset.
// Time: O(n)
// Space: O(n)

import java.util.*;

class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        int l = s.length();
        if (l < 10 || l > 100000) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();

        for (int i = 0; i<=l-10; i++) {
            String subStr = s.substring(i,i+10);
            if (!set.add(subStr))
                result.add(subStr);
        }
        return new ArrayList<>(result);
    }
}
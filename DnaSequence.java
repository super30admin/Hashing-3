// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class DnaSequence {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> result = new HashSet<>();
            Set<String> subStrings = new HashSet<>();

            for(int i=0; i<=s.length()-10; i++) {
                String subStr = s.substring(i, i+10);
                if(subStrings.contains(subStr)) {
                    result.add(subStr);
                } else {
                    subStrings.add(subStr);
                }
            }

            return new ArrayList<>(result);
        }
    }
}

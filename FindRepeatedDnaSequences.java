// Problem 187. Repeated DNA Sequences
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sequence = s.substring(i, i + 10);
            if (!seen.add(sequence)) {
                repeated.add(sequence);
            }
        }
        return new ArrayList<>(repeated);
    }
}
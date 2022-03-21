// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for(int i = 0; i < len-9; i++) {
            String seq = s.substring(i, i+10);
            if(set.contains(seq)) {
                result.add(seq);
            } else {
                set.add(seq);
            }
        }
        return new ArrayList<>(result);
    }
}

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :NO

/*
Approach
we are using 2 hashsets 
appraoch is if we see a sequence once we store it as seen but if we see it second time is means its repeating 
so add it to result
*/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        HashSet<String> allStr = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < n - 9; i++) {
            String temp = s.substring(i, i + 10);
            if (allStr.contains(temp)) {
                result.add(temp);
            } else {
                allStr.add(temp);
            }
        }
        return new ArrayList<>(result);
    }
}
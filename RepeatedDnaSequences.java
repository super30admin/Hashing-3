// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        if(s == null || s.length() == 0) return new ArrayList<>();
        
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        
        for(int i = 0; i <= s.length() - 10; i++) {
            
            String sub = s.substring(i, i + 10);
            
            if(set.contains(sub)) {
                result.add(sub);
            }
            
            set.add(sub);
        }
        
        return new ArrayList<>(result);
    }
}
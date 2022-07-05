// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        if(s.length() < 10) {
            return new ArrayList<>();
        }
            
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        
        for(int i = 0; i <= s.length() - 10; i++) {
            String pattern = s.substring(i, i + 10);
            
            if(set.contains(pattern)) {
                result.add(pattern);
            }
            
            set.add(pattern);
        }
        
        
        return new ArrayList<>(result);
    }
}
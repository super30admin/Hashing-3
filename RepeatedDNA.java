// Time Complexity : O(n)    
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We take two hashsets one for result and the other for comparison
// we repeatedly create sub strings of length 10 and add them to the set
// if we already have the substring in the set we add it to the result subset


class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for(int i =0; i<=s.length() - 10; i++){
            String sub = s.substring(i, i+10);
            if(set.contains(sub)){
                result.add(sub);
                
            }
            else
                set.add(sub);
        }
        return new ArrayList<>(result);
    }
}
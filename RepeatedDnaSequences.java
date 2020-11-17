// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this:

// Your code here along with comments explaining your approach
// Using HashSet 
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> output = new HashSet<>();
        
        for(int i=0; i<=s.length()-10; i++){
            String subStr = s.substring(i, i+10);
            
            if(set.contains(subStr)){
                output.add(subStr);
            }else{
                set.add(subStr);
            }
        }
        
        return new ArrayList<>(output);
        
    }
}
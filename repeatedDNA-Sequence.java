// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// 
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> allStrs = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        
        for(int i=0; i<=s.length() - 10; i++){
            String sub = s.substring(i, i+10);
            if(allStrs.contains(sub)){
                result.add(sub);
            } else{
                allStrs.add(sub);
            }
        }
        return new ArrayList<>(result);
    }
}

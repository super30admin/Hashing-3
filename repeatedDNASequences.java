// Time Complexity : O(N)
// Space Complexity : O(2*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    1. Do sliding window technique with window size of 10.
    2. Move through and if we find a match, we add it to the hashmap.
    3. Return the resultant hashmap and avoid repeting
*/

// Your code here along with comments explaining your approach
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> completeList = new HashSet<String>();
        HashSet<String> smallList = new HashSet<String>();
        
        for(int i=0;i<s.length() - 9;i++) {
            String subStr = s.substring(i, i+10);
            if(completeList.contains(subStr)) {
                smallList.add(subStr);
            }
            
            completeList.add(subStr);
        }
        return new ArrayList<>(smallList);
    }
}

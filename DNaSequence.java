// Time Complexity : O(m) 
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> st = new HashSet<>();
        
        HashSet<String> res = new HashSet<>();        
        
        for(int i = 0; i <=s.length() - 10; i++)
        {
            String a = s.substring(i, i+10);
            if(!st.contains(a))
                st.add(a);
            else
                res.add(a);
        }
        return new ArrayList<>(res);
    }
}
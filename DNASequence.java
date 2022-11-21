// Time Complexity : O(n)
// Space Complexity : O(n)
// n is the length of string s
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> result = new HashSet<>();
        HashSet<String> set = new HashSet<>();

        for(int i = 0 ; i <= s.length()-10 ; i++){
            String sub = s.substring(i,i+10);

            if(set.contains(sub)){
                result.add(sub);
            }

            set.add(sub);
        }
        return new ArrayList<>(result);
    }
}

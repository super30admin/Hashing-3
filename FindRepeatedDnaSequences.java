// Time Complexity : The time complexity is O(n) where n is the length of the string
// Space Complexity : Te space complexity is O(n) where n is the length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        if(s.length() <= 10){
            return new ArrayList<>();
        }

        Map<String,Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        int n = s.length();

        for(int i=0;i<=n-10;i++){
            //create substrings of length 10
            String cur = s.substring(i,i+10);
            map.put(cur,map.getOrDefault(cur,0)+1);
        }

        for(String str:map.keySet()){
            //find represting sequences
            if(map.get(str) > 1){
                res.add(str);
            }
        }
        return res;
    }
}
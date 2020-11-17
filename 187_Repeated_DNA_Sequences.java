    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/repeated-dna-sequences/
    Time Complexity for operators : o(n^n) .. n is the length of the string
    Extra Space Complexity for operators : o(n) for (List<String> path) without recursive stack
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) 
    */  


class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> output = new HashSet<>();

        for(int i = 0;i < s.length()-10+1; i++){
            String sub_string = s.substring(i, i+10);
            
            if(hashSet.contains(sub_string)){
                output.add(sub_string);
            }else{
                hashSet.add(sub_string);
            }
        }
        
        return new ArrayList<>(output);
    }
}
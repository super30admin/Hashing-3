## Problem1  Repeated DNA Sequences (https://leetcode.com/problems/repeated-dna-sequences/)

In this problem we will generate a substrings of length 10 and add it in a hashset if again we get the same substring then we will add it in a 
result set which is also a hashset. Why do we need result as a hashset because if there are 3 substrings which are similar then we will 
end up having duplicate strings. Then we will convert a hashset to a list of strings

Time Complexity : O(n) -> why not n*n because we are ignoring generation of substrings here as it will be of same size 10 and it is constant
Space Complexity : O(n) -> We will end up storing at max n strings not more than that

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if( s==null || s.length()<10){
            return new ArrayList<>();
        }
        HashSet<String> set=new HashSet<>();
        HashSet<String> result=new HashSet<>();

        for(int i=0;i<=s.length()-10;i++){
            String substring = s.substring(i,i+10);
            if(set.contains(substring)){
                result.add(substring);
            }
            else{
                set.add(substring);
            }
        }
        return new ArrayList<>(result);
    }
}
//Time Complexity:O(N)
//Space Complexity:O(N)
//Approach: Create a map to hold all possible substrings of length 10 from the given string and their number of occurences. Add those substrings that occur exactly 2 times in the input string. This is done to reach the answer and to avoid duplicates.

//This code was executed successfully and got accepted in leetcode.

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res=new ArrayList<>();
        
        Map<String,Integer> map=new HashMap<>();
        
        int i=0;
        while(i+10<=s.length()){
            String temp=s.substring(i,i +10);
            map.put(temp,map.getOrDefault(temp,0)+1);
            if(map.get(temp)==2){
                res.add(temp);
            }
            i++;
        }
        return res;
    }
}
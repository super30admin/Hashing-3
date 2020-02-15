// TC:O(n)
// SC:O(n)

32 / 32 test cases passed.
Status: Accepted
Runtime: 16 ms
Memory Usage: 51.3 MB

Approach: Make a hashset of all possible substrings by moving a sliding window of size 10. Check whether any new substring is already 
present in hashset.If yes add it to another hashset.Second hashset is needed because if a pattern comes for the third time, still
it should be present in the result only once. Hashset help in this.Finally convert the hashset to list and return.

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        
        Set<String> all_strings = new HashSet<>();
        
        Set<String> result = new HashSet<>(); // caoont be a list as when substring comes three times, in list
        // it will be added again        
        
        for(int start=0; start<s.length()-9 ;start++){
            String str = s.substring(start,start+10);
            
            if(all_strings.contains(str)){
                result.add(str);
            }else{
                all_strings.add(str);
            }
            
        }
        
        return new ArrayList<>(result);
        
    }
}



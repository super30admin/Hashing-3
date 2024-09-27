/*
Approach: Looking for 10 characters in the given string s at one time .If already present in hashset then add to result else keep adding to the allSubs hashset
*/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
       
        HashSet<String> allSubs = new HashSet();
        HashSet<String> result = new HashSet();
        String sub = null;
        for(int i = 0 ; i <= s.length()-10;i++){  // O(n) 
            sub = s.substring(i,i+10);           // O(10)
            if(allSubs.contains(sub)) {
                result.add(sub);
            }   
            allSubs.add(sub);                                  
        }
        return new ArrayList<>(result);
    }
}

/*
Time complexity: O(n*10) ie O(n)
Space complexity :O(1)


For input 
"AAAAAAAAAAA"
output is the same "AAAAAAAAAAA"

For input AAAAACCCCC there is no repeated sequence output is []
*/
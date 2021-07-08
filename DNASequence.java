/* Time Complexity : O(n) where n is the length of the sequence
// Space Complexity : O(n) wheren is the number of sequence generated stored in the set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Algorithm: As you go ahead, generate the possible sequences of 10 length at each character and store them into the set to make the sequences unique.
The result is also a unique set since we dont want duplicates. if the sequence is contained by the set implies add it to the result. Since it implies
the same sequence has been generating again which is repetition.
*/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> result = new HashSet<>();
        if(s == null || s.length() == 0) return new ArrayList<>(result);                            // Base case
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i <= s.length()-10; i++){
            String sub = s.substring(i,i+10);                                                   // Generate sequences of length 10 at each index
            if(set.contains(sub)){                                                          // If the set contains the sequence
                result.add(sub);                                                                        // Add it to the result
            } else{
                set.add(sub);                                                               // Add it for check
            }
        }
        return new ArrayList<>(result);
    }
}
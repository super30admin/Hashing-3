// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class RepeatedDNASequence {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            int sLen = s.length();
            List<String> result = new ArrayList<>();

            if(sLen < 10)
                return result;

        /*Sliding window
        create sub str of len 10 and store it in hashset
        if new sub str matches then store it in result hashset */

            Set<String> set = new HashSet<>();
            Set<String> reSet = new HashSet<>();

            int start = 0, end = 9;

            while(end < sLen){
                String sub = s.substring(start, end+1);
                if(!set.contains(sub)){
                    set.add(sub);
                }
                else{
                    reSet.add(sub);
                }
                start++;
                end++;
            }

            result = new ArrayList<>(reSet);

            return result;
        }
    }
}

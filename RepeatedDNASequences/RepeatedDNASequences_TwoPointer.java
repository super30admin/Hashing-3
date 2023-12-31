/* Time Complexity : O(n) 
 *  n - length of the i/p string - s */
/* Space Complexity : O(n)
 * 	hashset - allSubStrs */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//Two Pointer

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if(n < 10) return new ArrayList<>();
        HashSet<String> allSubStrs = new HashSet<>();
        HashSet<String> resultStrs = new HashSet<>();
        //Create and store all substrings in a hashset 'allSubStrs' and add to the result 'resultStrs' if it is present in the 'allSubStrs'
        for(int i = 0; i <= n-10; i++){
            String subStr = s.substring(i, i+10);
            if(allSubStrs.contains(subStr)){
                resultStrs.add(subStr);
            } else {
                allSubStrs.add(subStr);
            }
        }
        return new ArrayList<>(resultStrs);
    }
}
/* Time Complexity : O(n) 
 *  n - length of the i/p string - s */
/* Space Complexity : O(n)
 * 	hashset - allSubStrs */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


//Rolling hash

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if(n < 10) return new ArrayList<>();
        HashSet<Long> allSubsHash = new HashSet<>();
        HashSet<String> resultStrs = new HashSet<>();
        long k = (long)Math.pow(4, 9);
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);map.put('C', 2);map.put('G', 3);map.put('T', 4);
        long hash = 0L;
        //Create and store all substrings hash value in a hashset 'allSubsHash' and add to the result 'resultStrs' if it is present in the 'allSubStrs'
        for(int i = 0; i < n; i++){
            //Out-going char
            if(i >= 10){
                char out = s.charAt(i-10);
                hash = hash - k*map.get(out);
            }
            //In-coming char
            char in = s.charAt(i);
            hash = hash*4 + map.get(in);
            if(allSubsHash.contains(hash)){
                resultStrs.add(s.substring(i-9, i+1));
            } else {
                allSubsHash.add(hash);
            }
        }
        return new ArrayList<>(resultStrs);
    }
}
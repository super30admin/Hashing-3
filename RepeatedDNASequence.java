// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(n) // in case all the substrings are different
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a hashmap of string to integer
// Get all the substrings of length 10 and add them to map, and if it exist increase the count
// If the string is already there in map and reoccured, we add it to the result list
// Finally return the result list
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> hm = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int i = 10; i <= s.length(); i++){
            String str = s.substring(i-10,i);
            int count = hm.getOrDefault(str, 0);
            if(count == 1){
                result.add(str);
            }
            hm.put(str, count + 1);
        }
        return result;
    }
}
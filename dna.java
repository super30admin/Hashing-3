// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        HashSet<String> resultSet = new HashSet<>();

        HashSet<String> repeatedString = new HashSet<>();
        
        for (int i = 0; i <= s.length() - 10; i++) {

            String temp = s.substring(i, i + 10); // get substring of 10 characters
 // check if repeatedString contains temp, if not add in repeatedString
            if (!repeatedString.contains(temp)) {
                repeatedString.add(temp);
            } else {
                resultSet.add(temp);
            }
        }        return new ArrayList(resultSet);
    }
}
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> resultSet = new HashSet<>();
        HashSet<String> repeatedString = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            // take substring to be checked
            String temp = s.substring(i, i + 10);
            // if hashset does not contain the string, add it in
            if (!repeatedString.contains(temp)) {
                repeatedString.add(temp);
            } else {// else add in result
                resultSet.add(temp);
            }
        }
        // we need to store results also in set so that they dont get repeated
        return new ArrayList(resultSet);
    }
}
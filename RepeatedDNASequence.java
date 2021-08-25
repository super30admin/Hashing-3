// TC: O(n)
// SC: O(n)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> result = new HashSet<>();
        HashSet<String> allSubs = new HashSet<>();
        for(int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if(allSubs.contains(sub)) {
                result.add(sub);
            } else {
                allSubs.add(sub);
            }
        }
        return new ArrayList<>(result);
    }
}
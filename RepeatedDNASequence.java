// Time: O(N) | Space: O(N)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // to have all substrings
        Set<String> set = new HashSet<>();
        // to have substrings that happened twice
        Set<String> res = new HashSet<>();
        for(int i=0;i<=s.length()-10;i++) {
            String sub = s.substring(i, i+10);
            if(set.contains(sub)) {
                res.add(sub);
            }
            set.add(sub);
        }
        return new ArrayList<>(res);
    }
}
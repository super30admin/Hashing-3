//Time Complexity: O(N)
//Space Complexity: O(N)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if (seen.contains(str)) {
                set.add(str);
            }
            seen.add(str);
        }
        return new ArrayList<String>(set);
    }
}

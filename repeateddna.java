// Two HashSet Solution
// Time complexity: O(N)
// Space complexity: O(N)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10) return new ArrayList<>();
        final int N = s.length();
        Set<String> repeatSet = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= N - 10; i++) {
            String substr = s.substring(i, i + 10);
            if (!seen.add(substr)) {
                repeatSet.add(substr);
            }
        }
        return new ArrayList<>(repeatSet);
    }
}
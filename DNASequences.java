// TC: O(n)
// SC: O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int start = 0;
        int end = 0;
        long hash = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);
        HashSet<Long> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            hash = hash * 4 + map.get(in);

            if (i >= 10) {
                char out = s.charAt(i - 10);
                hash = hash - (long) Math.pow(4, 10) * map.get(out);
            }

            if (i >= 9) {
                if (!set.contains(hash)) {
                    set.add(hash);
                } else {
                    result.add(s.substring(i - 9, i + 1));
                }
            }
        }
        return new ArrayList<String>(result);
    }
}
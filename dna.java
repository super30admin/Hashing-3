// Time Complexity: O(n) – single pass over the string with O(1) work per character using a rolling hash.
// Space Complexity: O(n) – up to O(n) hashes/substrings stored in the sets for seen windows and results.

// Map A/C/G/T → {1,2,3,4} and maintain a base-4 rolling hash; for each char do: hash = hash*4 + val(in).
// After the first 10 chars, drop the outgoing char with: hash -= val(out) * 4^10 to keep a 10-length window.
// From i ≥ 9, if this window’s hash was seen before, add s[i-9..i] to result; else record the hash; finally return the result list.

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();

        HashSet<Long> allSeq = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        long hash = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);

        long posFac = (long)Math.pow(4, 10);

        for(int i = 0; i < n; i++) {
            char in = s.charAt(i);
            hash = hash * 4 + map.get(in);

            if(i >= 10) {
                char out = s.charAt(i - 10);
                hash = hash - (posFac * map.get(out));
            }

            if(i >= 9) {
                if(allSeq.contains(hash)) {
                    result.add(s.substring(i - 9, i + 1));
                } else {
                    allSeq.add(hash);
                }
            }
        }

        return new ArrayList<>(result);
    }
}

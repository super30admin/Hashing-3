import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        return findRepeatedDnaSequencesRabinKarp(s);
    }
    // TC: O(N) where N is length of string
    // SC: O(N) where N is length of string
    private List<String> findRepeatedDnaSequencesRabinKarp(String s) {
        if (s.length() < 10) return new ArrayList<>();
        Set<Long> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        int n = s.length();
        long k = (long)Math.pow(4, 9);
        long hash = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);

        for (int i = 0; i < 10; i++) {
            hash = hash * 4 + map.get(s.charAt(i));
        }
        set.add(hash);
        for (int i = 10; i < n; i++) {
            char out = s.charAt(i - 10);
            hash = hash - map.get(out) * k;
            char in = s.charAt(i);
            hash = hash * 4 + map.get(in);
            if (set.contains(hash)) {
                String sub = s.substring(i - 10 + 1, i + 1);
                result.add(sub);
            }
            set.add(hash);
        }
        return new ArrayList<>(result);
    }
    // TC: O(N * 10) where N is length of string
    // SC: O(N) where N is length of string
    private List<String> findRepeatedDnaSequencesSub(String s) {
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        int n = s.length();
        for (int i = 0; i <= n - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                result.add(sub);
            }
            set.add(sub);
        }
        return new ArrayList<>(result);
    }
}

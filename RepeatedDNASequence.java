
//Time complexity : O(n)
//Space complexity : O(n)
import java.util.*;

public class RepeatedDNASequence {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = findRepeatedDnaSequences(s);
        System.out.println(result);
    }

    private static List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10)
            return new ArrayList<>();
        HashSet<Integer> allSubHash = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        int hash = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);
        int nl = (int) Math.pow(4, 9);
        for (int i = 0; i < s.length(); i++) {
            // For outgoing characters
            if (i >= 10) {
                char out = s.charAt(i - 10);
                hash = hash - map.get(out) * nl;
            }
            // For Incoming Characters
            char in = s.charAt(i);
            hash = hash * 4 + map.get(in);

            if (allSubHash.contains(hash)) {
                result.add(s.substring(i - 9, i + 1));
            } else {
                allSubHash.add(hash);
            }

        }
        return new ArrayList<>(result);
    }

}
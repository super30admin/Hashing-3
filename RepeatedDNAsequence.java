import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TC: O(n) as the input string is traversed
// SC: 2 * O(n) as 2 sets are used. which boils down to O(n).

// Runs successfully on leetcode
// 2 sets are used here. first set is used check if there is a duplicate. If yes, then only add it in result.
public class RepeatedDNAsequence {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")); // ["AAAAACCCCC","CCCCCAAAAA"]
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA")); // ["AAAAAAAAAA"]
    }

    private static List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            if (set.contains(s.substring(i, i + 10)))
                result.add(s.substring(i, i + 10));
            set.add(s.substring(i, i + 10));
        }
        return new ArrayList<>(result);
    }
}
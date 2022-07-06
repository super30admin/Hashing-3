import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1 {
    // TC : O(n)
    // SC : O(n)
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) return new ArrayList<>();

        Set<String> allString = new HashSet<>();
        Set<String> result = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String subString = s.substring(i, i + 10);
            if (allString.contains(subString)) {
                result.add(subString);
            }
            allString.add(subString);
        }

        return new ArrayList<>(result);
    }
}

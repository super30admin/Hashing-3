//Time Complexity O(N)
//Space Complexity O(N)
//Leetcode tested

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i <= s.length()-10; i++) {
            String subString = s.substring(i,i+10);
            if(set.contains(subString)) res.add(subString);
            set.add(subString);
        }
        return new ArrayList<>(res);
    }
}

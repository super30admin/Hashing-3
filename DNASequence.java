// Time Complexity : O(n) ; n - length of string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DNASequence {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();

        for(int i = 0 ; i < s.length() - 9; i++){
            String sub = s.substring(i, i+10);
            if(set.contains(sub)){
                result.add(sub);
            }
            set.add(sub);
        }
        return new ArrayList<>(result);
    }
}

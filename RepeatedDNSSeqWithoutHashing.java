import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Time Complexity : O(10n) -> n is the length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class RepeatedDNSSeqWithoutHashing {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> result = new HashSet<>();
        HashSet<String> subSets = new HashSet<>();
        int n = s.length();

        for(int i=0; i<n-9; i++){
            String sub = s.substring(i,i+10);
            if(subSets.contains(sub)){
                result.add(sub);
            }else{
                subSets.add(sub);
            }
        }
        return new ArrayList<>(result);
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// Time Complexity : O(n) -> n is the length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class FindRepeatedDNASequenceUsingHashing {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('A',1);
        map.put('C',2);
        map.put('G',3);
        map.put('T',4);
        HashSet<String> result = new HashSet<>();
        HashSet<Long> subSets = new HashSet<>();
        int n = s.length();
        long pow = (long)Math.pow(4,9);
        long hash = 0L;
        for(int i=0; i<n; i++){
            if(i>=10){
                char out = s.charAt(i-10);
                hash = hash - (map.get(out))*pow;
            }
            char in = s.charAt(i);
            hash = hash * 4 + (map.get(in));

            if(subSets.contains(hash)){
                result.add(s.substring(i-9,i+1));
            }else{
                subSets.add(hash);
            }
        }
        return new ArrayList<>(result);
    }
}

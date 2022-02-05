import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //o(n) time and o(n) space
        HashSet<String> allStrs = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for(int i = 0; i <= s.length() - 10; i++){
           String sub = s.substring(i, i + 10);
                if(allStrs.contains(sub)){
                   result.add(sub);
               } else {
                   allStrs.add(sub);
               }
        }
        return new ArrayList<>(result);
    }
}
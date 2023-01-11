// Time Complexity : O(n)
// Space Complexity : O(n) where n is the length of string s


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> result = new HashSet<>();
        HashSet<String> set = new HashSet<>();

        for(int i = 0 ; i <= s.length()-10 ; i++){
            String sub = s.substring(i,i+10);

            if(set.contains(sub)){
                result.add(sub);
            }

            set.add(sub);
        }
        return new ArrayList<>(result);
    }
}
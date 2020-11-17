// TC: O(n)
// SC: O(n)
import java.util.*;

public class Dnasequence {
    public List<String> findRepeatedDnaSequences(String s) {        
        HashSet<String> list = new HashSet<>();
        HashSet<String> output = new HashSet<>();
        String temp = "";
        for(int i=0; i<=s.length()-10; i++){
            temp = s.substring(i, i+10);
            if(output.contains(temp)){
                list.add(temp);
            }
            else{
                output.add(temp);
            }
        }
        return new ArrayList<>(list);
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for(int i=0; i<=s.length()-10;i++){
            if(set.contains(s.substring(i,i+10))){
                result.add(s.substring(i,i+10));
            }else set.add(s.substring(i,i+10));
        }
        return new ArrayList<>(result);
    }
}

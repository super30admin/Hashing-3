import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class repeated_dna {
    
    public List<String> findRepeatedDnaSequences(String s) {
         HashSet<String> allSubStrings = new HashSet<>();

        HashSet<String> result = new HashSet<>();

        for(int i=0; i<=s.length()-10; i++){

            String currentSubString = s.substring(i,i+10);

            if(allSubStrings.contains(currentSubString))result.add(currentSubString);

            allSubStrings.add(currentSubString);

        }

        return new ArrayList<>(result);
    }
    public static void main(String[] args) {
        repeated_dna r= new repeated_dna();
        List<String>res= new ArrayList<>();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        res=r.findRepeatedDnaSequences(s);
    }
}


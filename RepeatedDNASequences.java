import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Time Complexity : O(n); where n is length of input string
//Space Complexity : O(n)
public class RepeatedDNASequences { 
	/**Approach: Hashing**/	
	public List<String> findRepeatedDnaSequences(String s) {
        int n= s.length();
        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for(int i=0; i<=n-10; i++){
            String substr = s.substring(i, i+10);            
            if(set.contains(substr))
                res.add(substr);
            set.add(substr);
        }
        return new ArrayList<>(res);
    }
    
	// Driver code to test above
	public static void main (String[] args) {	
		RepeatedDNASequences ob  = new RepeatedDNASequences();			
		String s= "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		System.out.println("All the 10-letter-long sequences that occur more than once in a DNA molecule: "+ob.findRepeatedDnaSequences(s));
	}
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/*
Time Complexity: O(N), here N is the length of the given string
Space Complexity: O(N) size of the HashSet used
Run on leetcode: yes
Any difficulties: No

Approach:
1. Using Seen and repeated set and making string of 10 characters using substring method
 */
public class RepeatedDNASequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        for (int i = 0; i < s.length()-9; i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }

    public static void main(String[] args){
        System.out.println("Repeated DNA Sequence: "+ findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}

//time complexity- O(N)
//space complexity- O(N)
import java.util.*;
public class RepeatedDNASequence {
    static List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if(len < 10)return new ArrayList<>();

        HashSet<String> sol = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);

        HashSet<Integer> hashValue = new HashSet<>();
        int hash = 0;
        int power = (int) Math.pow(4, 9);
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(i >= 10) {
                hash = hash - (map.get(s.charAt(i-10)) * power);
            }
            hash = hash*4 + map.get(c);

            if(i >= 9) {
                if(hashValue .contains(hash)) {
                    String sb = s.substring(i-9, i+1);
                    sol.add(sb);
                } else {
                    hashValue.add(hash);
                }
            }
        }
        return new ArrayList<>(sol);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println("DNA: "+ s);
        System.out.println("Repeated DNA Sequences: " +  findRepeatedDnaSequences(s));
    }
}

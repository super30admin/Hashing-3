import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class RepeatedDNASequencesRollingHash {

        // Rabin - Karp algorithm - Rolling Hash for patterns - Time O(n) and Space O(n)

        public List<String> findRepeatedDnaSequences(String s) {

            int n = s.length();
            if(n < 10) return new ArrayList<>();

            // map
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('A', 1);
            map.put('C', 2);
            map.put('G', 3);
            map.put('T', 4);

            // hash sets
            HashSet<String> result = new HashSet<>();     // O(n) space
            HashSet<Integer> seen = new HashSet<>();

            int hash = 0;
            int outFactor = (int) Math.pow(4, 10);

            // iterate over string s
            for(int i = 0; i < n; i++){         // O(n)

                // in
                char in = s.charAt(i);
                hash = hash * 4 + map.get(in);

                // out
                if(i > 9){
                    char out = s.charAt(i - 10);
                    hash = hash - map.get(out) * outFactor;
                }

                // add to result if pattern's hash seen before
                if(seen.contains(hash)){

                    result.add(s.substring(i-9, i+1));
                }

                // add current hash to see set
                seen.add(hash);
            }

            // output
            return new ArrayList<>(result);
        }

        public static void main(String[] args) {

            RepeatedDNASequencesRollingHash obj = new RepeatedDNASequencesRollingHash();

            Scanner scanner = new Scanner(System.in);

            System.out.println("String s: ");
            String s = scanner.nextLine();

            List<String> answer = obj.findRepeatedDnaSequences(s);

            System.out.println("Repeated DNA sequences are: ");
            for(String sequence: answer) {

                System.out.println(sequence);
            }
        }

}

/*
Time Complexity = O(n) = O(n - l)

O(n - l) where l = 10

Space Complexity = O(n) = O(n - l)
*/
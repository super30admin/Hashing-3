import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class RepeatedDNASequences {

        // Hash Set - Brute Force - Time O(nk) and Space O(nk)

        public List<String> findRepeatedDnaSequences(String s) {

            int n = s.length();
            if( n < 10) new ArrayList<>();

            // two hash sets
            HashSet<String> allSequences = new HashSet<>();
            HashSet<String> result = new HashSet<>();

            // iterate over s
            for(int i = 0; i <= n - 10; i++) { // O(n)

                String curr = s.substring(i, i+10);     // O(k)

                // if current sequence is repeated
                if(allSequences.contains(curr)) {       // O(k)

                    // add to result
                    result.add(curr);
                }

                // add current sequence to hash set of all sequences
                allSequences.add(curr);                  // O(k)
            }

            // output
            return new ArrayList<>(result);
        }

        public static void main(String[] args) {

            RepeatedDNASequences obj = new RepeatedDNASequences();

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
Time Complexity = O(nk)
Space Complexity = O(nk)
*/

/**
 * Finds all 10-letter-long DNA sequences that occur more than once in the input string.
 * Uses rolling hash with a sliding window to efficiently detect repeated sequences.
 * Returns a list of repeated DNA substrings found in the sequence.
 */
// Time Complexity: O(N), where N is the length of the input string
// Space Complexity: O(N), for storing hash values and repeated sequences
public class RepeatedDNASequence {

    public List<String> findRepeatedDnaSequences(String s) {
        //ROlling Hash pattern

        int n = s.length(); 

        HashSet<Long> allSeq = new HashSet<>();
        HashSet<String> result = new HashSet<>(); 

        long hash = 0; 

        HashMap<Character, Integer> map = new HashMap<>(); 
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);

        long posFac = (long) Math.pow(4,10);

        for(int i = 0; i < n; i++) {
            char in = s.charAt(i);
            hash = hash * 4 + map.get(in);

            if(i >=10) {
                char out = s.charAt(i-10);
                hash = hash - (posFac * map.get(out));
            }
            if(allSeq.contains(hash)) {
                result.add(s.substring(i-9, i+1));
            } else {
                allSeq.add(hash);
            }
        }
        return new ArrayList<>(result);
    }
    
}

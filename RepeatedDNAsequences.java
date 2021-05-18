// TC - O(n), SC - O(n)

// LC - 187

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // Initialize 2 hashsets
        Set<String> set = new HashSet<>();
        Set<String> output = new HashSet<>();
        // Iterate over string 
        for(int i=0; i<=s.length()-10; i++){
            // create a substring of length 10
            String subseq = s.substring(i, i+10);
            // if subseq is present in set, add it to output set
            if(set.contains(subseq)){
                output.add(subseq);
            }
            set.add(subseq);
        }
        // add output to result and return it.
        List<String> result = new ArrayList<>();
        result.addAll(output);
        return result;
    }
}
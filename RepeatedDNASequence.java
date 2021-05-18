class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        
        //iterating through the string with substring of length 10
        for(int i = 0; i <= s.length()-10; i++){
            String sub = s.substring(i, i + 10);
            // if the sequence is repated, add it to result set
            if(set.contains(sub)){
                result.add(sub);
            }
            set.add(sub);
        }
        
        //return all the strings in the form of List
        return new ArrayList<>(result);
    }
}
// Time Complexity: O(n) n -> number of sequences that can be formed
// Space Complexity: O(n)
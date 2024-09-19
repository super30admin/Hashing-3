//Time = O(n), length of input string
//Space = O(n)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // Initialize a set to store all the unique substrings of length 10
        Set<String> seen = new HashSet<>();
        // Initialize a set to store all the repeated substrings of length 10
        Set<String> repeated = new HashSet<>();
        
        // Iterate through the string, extracting each substring of length 10
        for (int i = 0; i < s.length() - 9; i++) {
            String substring = s.substring(i, i + 10);
            // Check if the substring has already been seen before
            if (!seen.add(substring)) {
                // If it has, add it to the repeated set
                repeated.add(substring);
            }
        }
        
        // Convert the repeated set to a list and return it
        return new ArrayList<>(repeated);
    }
}

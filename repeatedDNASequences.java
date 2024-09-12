// Time Complexity : O((n-l)*l) where n is the length of the string s and l is the length of the sequence. 
// Since l = 10, T = O(n)  
// Space Complexity : O((n-l)*l) where n is the length of the string s and l is the length of the sequence. 
// Since l = 10, S = O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Brute force way of checking all substrings

class repeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if (seen.contains(str)) {
                set.add(str);
            }
            seen.add(str);
        }
        return new ArrayList<String>(set);
    }
}
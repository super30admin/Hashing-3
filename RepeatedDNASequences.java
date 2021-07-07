// Time Complexity : O(N^2), N-> length of string, substring function adds an O(N) factor as well
// Space Complexity : O(N), set space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach: Brute force
// Iterate over the entire string, find the substring till required length starting from current index.
// Add the substring in set. If the same substring is found again while traversing, it will be added in the result set. 
/*
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // edge case
        if(s == null)
            return new ArrayList<>();
        
        int len = s.length();
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for(int i = 0; i < len-10+1; i++) {
            String curr = s.substring(i, i+10);
            if(set.contains(curr)) {
                res.add(curr);
            }
            set.add(curr);
        }
        
        return new ArrayList<>(res);
    }
}
*/

// Time Complexity : O(N), N-> length of string
// Space Complexity : O(N), set space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach: Rabin Karp algorithm
// The main idea is to create a window of required length and identify the string's uniqueness using a robust hash function.
// The window will be shifted on each iteration.

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // edge case
        if(s == null || s.length() < 10)
            return new ArrayList<>();
        
        // // mapping character to a number
        // int[] charMap = new int[26]; // considering 26 chars for generalization
        // // In this case assuming the characters to be of uppercase
        // for(char ch = 'A'; ch <= 'Z'; ch++) {
        //     charMap[ch-'A']++;
        // }
        
        int len = s.length();
        long val = 0;
        int L = 10;
        int base = 11; // choosing a prime base to avoid hash collision
        Set<Long> set = new HashSet<>(); 
        Set<String> res = new HashSet<>();
        // creating window
        for(int i = 0; i < L; i++) {
            //mapping character in a polynomial function and finding its corresponding integer value 
            char ch = s.charAt(i);
            val = val*base + (ch-'9'); // considering ascii value of characters in computation
        }
        set.add(val);
        // window has been created, now all the subsequent computations will be done in O(N) time
        // we just need to subtract the value being contributed by i-10 character and add the value being contributed by ith character
        for(int i = 10; i < len; i++) {        
            val = (long)((val-((s.charAt(i-L)-'9') * Math.pow(base, (L-1))))*base + (s.charAt(i)-'9'));
            if(set.contains(val))
                res.add(s.substring(i-L+1,i+1));
            else
                set.add(val);
        }
        
        return new ArrayList<>(res);
    }
}





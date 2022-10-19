import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(n) where n = length of string
//Space Complexity : O(n) where n = length of string
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//187. Repeated DNA Sequences (Medium) - https://leetcode.com/problems/repeated-dna-sequences/
// Time Complexity : O(n) where n = length of string
// Space Complexity : O(n) where n = length of string
class Solution {
 public List<String> findRepeatedDnaSequences(String s) {
     HashSet<String> result = new HashSet<>();
     HashSet<String> set = new HashSet<>(); // O(n)
     
     for (int i = 0; i <= s.length() - 10; i++) { // O(n)
         String sub = s.substring(i, i + 10);
         
         if (set.contains(sub)) {
             result.add(sub);
         }
         
         set.add(sub);
     }
     
     return new ArrayList<>(result);
 }
}
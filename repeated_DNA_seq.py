"""
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Use set to keep track of already occured substring, add to result if that's case 
and return the result
"""
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        seq_set = set()
        result = set()
        for i in range(len(s)-9):
            substr =  s[i:i+10]
            if substr in seq_set:
                result.add(substr)
            seq_set.add(substr)
        return list(result)
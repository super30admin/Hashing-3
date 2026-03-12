# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# DNA sequences are length 10.
# Slide a window of size 10 across the string.
# Track seen sequences and repeated sequences using sets.

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        seen = set()
        repeated = set()
        
        for i in range(len(s) - 9):
            seq = s[i:i+10]
            
            if seq in seen:
                repeated.add(seq)
            else:
                seen.add(seq)
        
        return list(repeated)
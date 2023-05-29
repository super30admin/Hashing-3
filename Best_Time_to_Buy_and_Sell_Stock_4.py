# Time Complexity : O(N), where N is the length of the input string s.
# Space Complexity : O(N)
from typing import List

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        seen = set()
        repeated = set()
        result = []
        
        # Slide the window of length 10 over the DNA sequence
        for i in range(len(s) - 9):
            sequence = s[i:i+10]
            if sequence in seen:
                repeated.add(sequence)
            else:
                seen.add(sequence)
        
        # Add the repeated DNA sequences to the result list
        result.extend(repeated)
        
        return result
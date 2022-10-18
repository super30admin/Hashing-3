"""
Problem1  Repeated DNA Sequences (https://leetcode.com/problems/repeated-dna-sequences/)
"""

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        """
        Using sliding window + hashset
        TC:O(N) N is leb of string
        SC:O(N)
        """
        visited_set = set()
        res = set()
        
        for i in range (len(s)-9):
            new_str = s[i: i+10]
            if new_str in visited_set:
                res.add(new_str)
            
            visited_set.add(new_str)
            
        return res
                
            

        
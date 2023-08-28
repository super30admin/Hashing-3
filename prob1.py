# Time Complexity : O(n)
# Space Complexity :O(1)
# Passed on Leetcode: yes

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if len(s) < 10:
            return None
        
        map = {'A': 1,
                'C':2,
                'G':3,
                'T':4
                }

        rollHashV = 0
        subS = set()
        res = set()
        for i in range(len(s)):
            if i >= 10:
                rollHashV = rollHashV - map[s[i-10]]*(4**9)
            
            rollHashV = rollHashV*4 + map[s[i]]

            if rollHashV in subS:
                res.add(s[i-9:i+1])
            subS.add(rollHashV)
            

        return list(res)

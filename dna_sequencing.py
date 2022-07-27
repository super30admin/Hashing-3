# Time Complexity :O(N) N is length of the string
# Space Complexity :O(N) N is length of the string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        result = set()
        allSequences = set()
        n = len(s)
        for i in range(0, n-9):
            sub = s[i: i+10]
            
            if sub in allSequences:
                result.add(sub)
            else:
                allSequences.add(sub)
                
        return list(result)
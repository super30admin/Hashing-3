#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        allStrs = set()
        res = set()
        for i in range(len(s)-9):
            sub = s[i:i+10]
            if sub in allStrs:
                res.add(sub)
            allStrs.add(sub)
        return list(res)
        

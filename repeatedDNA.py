#Time: O(N)
#Space: O(N)

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if len(s)  == 0:
            return []
        rep = set()
        result = set()
        
        for i in range(len(s)-9):
            t  = s[i:i+10]
            if t in rep:
                result.add(t)
            rep.add(t)
            
        return result
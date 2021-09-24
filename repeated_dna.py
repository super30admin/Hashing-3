#Time complexity : O(N) N:len(s)
#space complexity : O(N)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if len(s) <10 or s=='' :
            return []
        visited = set()
        res = set()
        for i in range(0,len(s)-9,1):
            chars = s[i:i+10]
            if chars not in visited:
                visited.add(chars)
            else:
                res.add(chars)
            
                
        return res
        
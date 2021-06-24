class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        if len(s) < 10:
            return []
        
        seen = set()
        repeated = set()
        
        for i in range(len(s)-9):
            sub = s[i:i+10]
            #print(sub)
            if sub in seen:
                repeated.add(sub)
            seen.add(sub)
        return repeated

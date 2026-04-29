class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if len(s)<=10:
            return []
        
        res = []
        seen = dict()
        seen[s[:10]]=1
        for idx in range(1,len(s)-9):
            curr = s[idx:idx+10]
            if curr not in seen:
                seen[curr]=0
            seen[curr]+=1
            if seen[curr]==2:
                res.append(curr)
        return res




# TIme complexity - O(N)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        n = len(s)
        result = set()
        subs = set()
        for i in range(n-9): # careful
            cur = s[i:i+10]
            if cur not in subs:
                subs.add(cur)
            else:
                result.add(cur)
        return list(result)

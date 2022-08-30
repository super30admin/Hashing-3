# HashMap
# TC: O(n)
# SC: O(n)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        # base
        if len(s) < 11: return []
        
        intMap = {'A': 0, 'T': 1, 'G': 2, 'C': 3 }
        keys, res, key = {}, [], 0
        
        mask = (1 << 20) - 1
        # logic
        for i in range(9):
            key = (key << 2) + intMap[s[i]]
        
        for i in range(9, len(s)):
            key = ((key << 2) + intMap[s[i]]) & mask
            if key in keys:
                keys[key] += 1
                if keys[key] == 2:
                    res.append(s[i-9:i+1])
            else:
                keys[key] = 1
        return res
                    
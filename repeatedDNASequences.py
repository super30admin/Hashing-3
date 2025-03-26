class Solution:
    # TC : O(n)
    # SC : O(n)
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if s is None or len(s)<10:
            return []
        hmap = {}
        for i in range(len(s)-10+1):
            ss = s[i:i+10]
            if ss in hmap:
                hmap[ss] += 1
            else:
                hmap[ss] = 1
        res = []
        for key,val in hmap.items():
            if val >=2:
                res.append(key)
        return res
        
from typing import List


# class Solution:
#     def findRepeatedDnaSequences(self, s: str) -> List[str]:
#         allstr = set()
#         res = set()
#         n = len(s)
#         for i in range(n-9):
#             substr = s[i:i+10]
#             if substr in allstr:
#                 res.add(substr)
#             else:
#                 allstr.add(substr)
#         return list(res)


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        allstr = set()
        res = set()
        n = len(s)
        mapchar = {'A':1,'C':2,'G':3,'T':4}
        posfactor = 4**10
        hashval = 0
        for i in range(n):
            hashval = hashval*4 + mapchar[s[i]]
            if i>=10:
                hashval -= posfactor*mapchar[s[i-10]]
            if i>=9:
                if hashval in allstr:
                    res.add(s[i-9:i+1])
                else:
                    allstr.add(hashval)
        return list(res)
        
        
#time O(N)
#space O(N)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        res, dic = [], {}
        for i in range(0, len(s)-9):
            substring = s[i:i+10]
            if substring in dic and dic[substring] == False:
                res.append(substring)
                dic[substring] = True
            elif substring not in dic:
                dic[substring] = False
        return res
                
        
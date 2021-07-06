"""
time : o(n)
space : o(n)
"""
class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        
        seen = set()
        res = set()
        for i in range(len(s) - 10 +1): #checking for every string of length 10 if it is repeated by maintaining a seen hashset
            if s[i:i + 10] in seen:
                res.add(s[i:i + 10])
            
            seen.add(s[i:i + 10])
                
        return res
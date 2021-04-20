#Time Complexity :o(n) 
#Space Complexity :o(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if(len(s)<10):
            return []
        
        hset=set()
        result=set()
        for i in range(len(s)-9):
            sub=s[i:i+10]
            if(sub in hset):
                result.add(sub)
            hset.add(sub)
        return result
            
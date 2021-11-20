# // Time Complexity :O(n) 
# // Space Complexity :O(n) 
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        temp=set()
        res=set()
        for i in range(len(s)-9):
            if s[i:i+10] in temp:
                res.add(s[i:i+10])
            else:
                temp.add(s[i:i+10])
        return res
            
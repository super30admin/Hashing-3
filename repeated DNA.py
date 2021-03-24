"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination

go from left to right 
look at the substring of i: i+10
put that into a set
if that is already in the set then append it to the result array


"""

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        k = set()
        res = set()
        for i in range(len(s)-9):
            if s[i:i+10] not in k:
                k.add(s[i:i+10])
            else:
                # if s[i:i+10] not in res:
                res.add(s[i:i+10])
        return list(res)
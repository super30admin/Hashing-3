"""
Time Complexity : O(N) 
Space Complexity : O(N*10)-worst case
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
We would iterate over the string, make a temp string of defined length 10. Check if it already existed (in a set), then we can add
it to result. If not, just add it to a temp array. 
"""


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        resultSet = set()
        if not s:
            return resultSet
        tempSet = set()
        l = len(s)
        for i in range(l):
            string = s[i:i+10]
            if string in tempSet:
                resultSet.add(string)
            tempSet.add(string)
        return resultSet

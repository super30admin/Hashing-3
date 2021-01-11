#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        allSubstrings = set()
        result = set()

        for i in range(len(s)-9):
            sub = s[i:i+10]
            if sub in allSubstrings:
                result.add(sub)
            allSubstrings.add(sub)

        return list(result)

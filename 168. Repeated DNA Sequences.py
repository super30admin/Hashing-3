class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        allstrs = set()
        result = set()

        for i in range((len(s) + 1) - 10):
            sub = s[i: i + 10]
            if sub in allstrs:
                result.add(sub)
            else:
                allstrs.add(sub)

        return list(result)
        # return [i for i in result]

# Hashing
# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
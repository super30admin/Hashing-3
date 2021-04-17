# Time Complexity : O(N) since we are only getting 10 substring each time so that is constant
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Use HashMap to store the count of substring of length 10


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if not s:
            return None

        dict = {}
        res = []
        for i in range(len(s) - 10 + 1):
            substring = s[i:i + 10]
            if substring not in dict:
                dict[substring] = 1
            else:
                dict[substring] += 1

        for key, val in dict.items():
            if dict[key] > 1:
                res.append(key)
        return res

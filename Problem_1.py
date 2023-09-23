# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        ans = set()
        seen = set()
        for i in range(len(s) - 9):
            seq = s[i:(i + 10)]
            if seq in seen:
                ans.add(seq)
            seen.add(seq)
        return list(ans)
# Time Complexity : O(n)
# Space Complecity : O(n)
# The code ran on LeetCode
# Maintain rolling hash to get repeated sequences of length 10

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        value_map = {'A' : 1, 'C' : 2, 'G' : 3, 'T' : 4}
        hash_set = set()
        result = set()
        rolling = 0
        for i in range(len(s)):
            if i >= 10:
                out = value_map[s[i-10]]
                rolling = rolling - out*(4**9)
            val = value_map[s[i]]
            rolling = rolling*4 + val
            if rolling not in hash_set:
                hash_set.add(rolling)
            else:
                result.add(s[i-9:i+1])

        return list(result)
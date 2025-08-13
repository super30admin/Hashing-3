"""
Time Complexity: O(n)
Space Complexity: O(n)
"""
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        n = len(s)
        hashSet = set()
        result = set()
        for i in range(n - 9):
            substring = s[i:i+10]
            if substring in hashSet:
                result.add(substring)
            else:
                hashSet.add(substring)
        return list(result)
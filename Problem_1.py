from typing import List
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        allSubs = set()
        result = set()
        for i in range(len(s)-9):
            sub = s[i:i+10]
            if sub in allSubs:
                result.add(sub)
            allSubs.add(sub)
        return result

# Time Complexity: O(n)
# Space Complexity: O(n)
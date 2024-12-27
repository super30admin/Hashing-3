#Time Complexity: O(N)
#Space Complexity: O(N)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        seen,result = set(),set()
        for l in range(0,len(s)-9):
            curr = s[l:l+10]
            if(curr in seen):
                result.add(curr)
            else:
                seen.add(curr)
        return list(result)
        
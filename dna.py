#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        subStrings = set()
        res = set()
        for i in range(len(s)-10+1):
            subString = s[i:i+10]
            if subString in subStrings:
                res.add(subString)       
            else:
                subStrings.add(subString)
        return list(res)
                
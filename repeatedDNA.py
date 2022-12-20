#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        found = set()
        res = set()

        for i in range(len(s) - 9):
            tmp = s[i: i+10]
            if tmp in found:
                res.add(tmp)
            found.add(tmp)
        
        return list(res)
        
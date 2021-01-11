#Time: O(N)
#Space: O(N)
class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        res = {}
        op = []

        for i in range(0, len(s) - 9):
            temp = s[i:i+10]
            if temp not in res:
                res[temp] = 1
            else:
                res[temp] += 1


        for key, value in res.items():
            if value > 1:
                op.append(key)

        return op

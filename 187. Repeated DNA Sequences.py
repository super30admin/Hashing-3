#Time Complexity:O(n)
#Space Complexity:O(1)

class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        result=set([])
        sequence=set()
        for i in range(len(s)):
            if s[i:i+10] in sequence:
                result.add(s[i:i+10])
            else:
                sequence.add(s[i:i+10])
        return result
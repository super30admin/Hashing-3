class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        windows = set()
        result = set()
        for i in xrange(len(s) - 9):
            sub_str = s[i:i+10]
            if sub_str in windows:
                result.add(sub_str)
            else:
                windows.add(sub_str)
        return list(result)

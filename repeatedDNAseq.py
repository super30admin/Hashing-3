class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        """
        TC:O(n)
        SC:O(1) since len of subseq is 10 which is constant
        """

        res = set()
        sett = set()

        for i in range(len(s)):
            sstr = s[i:i+10]
            if sstr in sett:
                res.add(sstr)
            else:
                sett.add(sstr)
        return res

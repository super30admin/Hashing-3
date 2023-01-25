class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        from collections import defaultdict
        hm = defaultdict(int)
        i = 0
        j = i + 10
        hs = set()

        while i<=len(s)-10:
            hm[s[i:j]] += 1
            if hm[s[i:j]] > 1:
                hs.add(s[i:j])
            i += 1
            j += 1
        return list(hs)
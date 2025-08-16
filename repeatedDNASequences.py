class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        #rolling hash 
        charMap = {"A":1, "C":2, "G":3, "T":4}
        hashmap = set()
        res = set()
        l=0
        hashedVal = 0
        for r in range(len(s)):
            
            if r - l + 1 == 11:
                hashedVal -= (charMap[s[l]] * 4**9)
                l += 1

            hashedVal = hashedVal*4 + charMap[s[r]] #doing this after removal of l to prevent overflow

            if r - l + 1 == 10:
                if hashedVal in hashmap:
                    res.add(s[l : r + 1])
                hashmap.add(hashedVal)

        return list(res)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if len(s) < 10:
            return []
        res = []
        # assign each of the four possible letters to the first four binary numbers
        letterToBin = {'A':0b00, 'C':0b01, 'G':0b10, 'T':0b11}
        currHash = letterToBin[s[0]]
        for i in range(1,10):
            currHash <<= 2
            binOfLetter = letterToBin[s[i]]
            currHash |= binOfLetter

        seenHashBefore = {}
        seenHashBefore[currHash] = False
        le=1
        for ri in range(10,len(s)):
            currLetter = s[ri]
            binOfLetter = letterToBin[currLetter]
            currHash <<= 2
            currHash &= ~(0b11 << 2*10)
            currHash |= binOfLetter
            if currHash in seenHashBefore and not seenHashBefore[currHash]:
                seenHashBefore[currHash] = True
                res.append(s[le:ri+1])
            # either currHash not in seenHashBefore or seenHashBefore[currHash]
            elif currHash not in seenHashBefore:
                seenHashBefore[currHash] = False
            le+=1
        return res
        # time = O(n)
        # memory = O(n)

        
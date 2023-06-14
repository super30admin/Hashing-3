class Solution:
    #TC-O(n),SC-O(n)
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        # using robin karp algorithm, find hash values of substrings of length 10 an dif same hashvalue is found , add to results
        if len(s)<10:
            return []
        result = set()
        seen = set()
        d = {'A':1,'C':2,'G':3,'T':4}
        hash=0
        for i in range(len(s)):
            inc = s[i]
            hash = hash*4 + d[inc]
            if(i>9):
                out = s[i-10]
                hash = hash - d[out]*pow(4,10)
                if hash in seen:
                    result.add(s[i-9:i+1])
            seen.add(hash)
        return list(result)
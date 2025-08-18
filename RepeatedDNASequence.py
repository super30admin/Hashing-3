class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        n = len(s)
        allSeq = set()
        result = set()

        hash_val = 0
        map_char = {'A': 1, 'C': 2, 'G': 3, 'T': 4}
        posFac = 4 ** 10

        for i in range(n):
            hash_val = hash_val * 4 + map_char[s[i]]

            if i >= 10:
                hash_val -= posFac * map_char[s[i - 10]]

            if i >= 9:
                if hash_val in allSeq:
                    result.add(s[i-9:i+1])
                else:
                    allSeq.add(hash_val)

        return list(result)
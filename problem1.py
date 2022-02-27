class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if s is None or len(s) == 0:
            return []

        tempSet = set()
        result = set()

        for i in range(0, len(s) - 10 + 1):
            if s[i:i + 10] not in tempSet:
                tempSet.add(s[i:i + 10])
            elif s[i:i + 10] not in result:
                result.add(s[i:i + 10])

        return list(result)

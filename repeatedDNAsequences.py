#O(n) time and O(n) space solution
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        sequence_seen = set()
        result = set()
        for i in range(len(s) - 9):
            currentSequence = s[i : i + 10]
            if currentSequence in sequence_seen:
                result.add(currentSequence)
            else:
                sequence_seen.add(currentSequence)
        return result
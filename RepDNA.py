"""187. Repeated DNA Sequences
TC -> O(n)
SC -> O(n)"""
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if len(s)<10:
            return []
        substring_set = set()
        result_set = set()
        
        for i in range(len(s)-9):
            sub = s[i:i+10]
            if sub in substring_set:
                result_set.add(sub)
            substring_set.add(sub)
        return result_set
        
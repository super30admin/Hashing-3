#To solve this problem, createe a window of 10 add it to set and then move along tthe string to check if the ptttern repeats. We use 2 hash sets for this, one to append the patterns and one to check tthe repeated pattern.
#Time Complexity: O(n)
#Space Complexity: O(2n)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        allsubs = set()
        result = set()
        for i in range(len(s)-9):
            sub = s[i:i+10]
            if sub in allsubs:
                result.add(sub)
            allsubs.add(sub)
        return list(result)
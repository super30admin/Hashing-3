#Time Complexity:O(n)
#Space Complexity:O(n)
#Approach: Use one hash set to hold all substrings of size 10 of the input string, if a string is encountered and already exists in sub string
#hashset append the repeated substring to the result. 
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        allSub=set()
        result=set()
        for i in range(len(s)-9):
            sub=s[i:i+10]
            if sub in allSub:
                result.add(sub)
            allSub.add(sub)
        return result
# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        # make two hashsets to store all the strings and the resultant repeating strings
        all_string = set()
        res = set()
        
        n = len(s)
        
        # traverse from 0 till the n-10th characters
        for i in range(n-9):
            
            # create substrings
            sub = s[i:i+10]
            
            # if the subtring is already present in the all_string set, only then add to res
            if sub in all_string:
                res.add(sub)
                
            # add the string to all_string as we have unique values because of the Hashset
            all_string.add(sub)
        
        # return the result
        return res

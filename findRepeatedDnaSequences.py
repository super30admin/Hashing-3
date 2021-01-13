"""
Time complexity is O(N)
Space Complexity  is O(1) 
because we are storing alphabets with 10 charcter len which are unique 



"""

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        res=set()
         
        allsubs=set() #initialize a set to store all the substr of len 10
    
        # Iterate over all 10 char long substrings
        for i in range(len(s)-9):
            sub = s[i:i+10]
            # Check if a 10 char long substring is already in set,
            # Add to result only if it is already in set
            if sub in allsubs:
                res.add(sub)
            else: #add to substr set 
                allsubs.add(sub)
        return res
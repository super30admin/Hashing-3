#time: O(n)
#space: O(n)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        n= len(s)
        #create substring of length 10, check if they exist in the set or not.
        # if they do add it to the res list
        vset=set()
        res=set()
        for i in range(10, n+1):
            if s[i-10:i] in vset:
                res.add(s[i-10:i])
            else:
                vset.add(s[i-10:i])
        return list(res)  

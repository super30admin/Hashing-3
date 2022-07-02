# Repeated DNA Sequences

# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        hmap={}
        res=set()
        
        for i in range(len(s)-9):
            j=i+10
            sequence = s[i:j]                   #for every subsequence with 10 length, check if its in the hashmap or not
            if sequence in hmap:
                if hmap[sequence]==1:
                    hmap[sequence]=0            #if already in the hashmap, set the count to 0 and add to the result set as its a duplicate
                    
                    res.add(sequence)
                else:
                    hmap[sequence]=1            #if not, just store the count as 1
            else:
                hmap[sequence]=1
        return list(res)                        #return the list of the set
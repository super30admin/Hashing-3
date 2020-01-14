'''
Leetcode - 187. Repeated DNA Sequences 
Time complexity - O(N)
space complexity - O(1)

Approach - 1) I traverse through the entire string with length 10
           2) if that substring is in ptn set, then we append to the res set.
           3) finally we convert set to list
           
'''
class Solution:
    def findRepeatedDnaSequences(self, nums: str) -> List[str]:
        res=set()
        ptn=set()
        s=""
        for i in range(0,len(nums)-9):
            s=nums[i:i+10]
            if s in ptn:
                res.add(s)
            ptn.add(s)
        
        return res
    
            
            
            
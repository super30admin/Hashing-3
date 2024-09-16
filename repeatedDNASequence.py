# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

# Approach:1 (coded below), sliding window + hashset
# Approach:2, can also be done by using hashmap(substring:#of occurences), 
# return the substrings with #of occurences>1



class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        L = 10
        n = len(s)
        #put subtrings of length 10 inside the hashset if it doesn't exist
        #if the substring already exists, add the substring to output
        
        hset = set()
        op = set()
        
        for i in range(n-L+1):
            temp = s[i:i+L]
            if temp in hset:
                op.add(temp[:])
            hset.add(temp)
            
        return op
            
        
# Time Complexity : O(n), Where n is number of elments in the string s
# Space Complexity : O(n), Where n is number of elements in the string s
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if(len(s)<=10):
            return []
        n=len(s)
        #Here instead of maintaing in hashmap we will use hashset
        hashset=set()
        result=set()
        for i in range((n-10)+1):
            subseq=s[i:i+10]
            if(subseq in hashset):
                #Here it is in hashset, Then will add the result set as this will avoid the duplication of element
                result.add(subseq)
            else:
                hashset.add(subseq)
        #print(result)
        return list(result)
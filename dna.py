# Time Complexity : O(N) where N is number of elements in s 
# Space Complexity : O(N) where N is number of elements in s
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using a rolling hash technique to efficiently compute hash values for each 10-letter-long substring in the DNA sequence.
# I maintain a set to track sequences that have already been seen and another set to store sequences that are repeated.
# The hash value is computed using a base-4 representation, where each character is mapped to a unique integer.
# As I slide through the string, I update the hash value and check if the current sequence has been seen before.
# If it has, I add it to the result set. Finally, I return the list of repeated sequences.


from typing import List
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        n = len(s)
        res = set()
        seq = set()
        hashval = 0
        charm = {'A':1,'C':2,'G':3,'T':4}
        fac = 4**10
        for i in range(n):
            hashval = hashval* 4 + charm[s[i]]
            if i >= 10:
                hashval -= fac * charm[s[i-10]]
            if i >= 9:
                if hashval in seq:
                    res.add(s[i-9:i+1])
                else:
                    seq.add(hashval)
        return list(res)
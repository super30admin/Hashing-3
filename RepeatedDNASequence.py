#All TC passed on leetcode


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:

        #Here we use sliding window approach. We store the window string in seq set if its not present in 
        #it else we add it to res set.
        #Time complexity - O(n)
        #Space complexity - O(n)
        res = set()
        seq = set()

        for i in range(len(s)-10+1):
            if s[i:i+10] in seq:
                res.add(s[i:i+10])
            else:
                seq.add(s[i:i+10])
        return res
        
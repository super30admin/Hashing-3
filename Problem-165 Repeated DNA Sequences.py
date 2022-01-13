# 187. Repeated DNA Sequences
# https://leetcode.com/problems/repeated-dna-sequences/

# Logic: Have sliding window of size 10. If the sequence comes 
# for the first time, add to hashmap. If already in tha hashmap, 
# change value and add to result.

# Time Complexity: O(n - l + 1) [l = 10 here]
# Space Complexity: O(n - l + 1)

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        res = list()
        
        hashmap = dict()
        
        for i in range(len(s) - 9):
            temp = s[i:i+10]
            if temp not in hashmap:
                hashmap[temp] = 0
            else:
                if hashmap[temp] == 0:
                    res.append(temp)
                    hashmap[temp] = 1
        return res
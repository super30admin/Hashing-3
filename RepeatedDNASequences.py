# TC: O(N) as we are iterating over the whole string and the slicing operation is constant time O(10)--> O(1). 
# SC: O(N) as worst case we would be adding all possible substrings of length 10 from the input string.

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if not s or len(s) == 0: 
            return 
        
        set1 = set()
        result_set = set()
        
        for i in range(len(s)): 
            j = i + 9
            if j >= len(s): 
                continue
            string = s[i:j + 1]
            
            if string not in set1: 
                set1.add(string)
            elif string not in result_set:
                result_set.add(string)
        
        
        return list(result_set)

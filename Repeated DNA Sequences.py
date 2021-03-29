class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        #Approach: HashSet
        #Time Complexity: O(len(s))
        #Space Complexity: O(len(s))
        
        result = []
        if len(s) <= 10:
            return 
        
        sequences = {}
        for i in range(len(s) - 9):
            seq = s[i:i+10]
            sequences[seq] = sequences.get(seq, 0) + 1
            if sequences[seq] == 2:
                result.append(seq)
                
        return result
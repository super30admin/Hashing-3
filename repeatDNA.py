class Solution:
    
    """
    Description: Find repeated DNA sequence
    
    Time Complexity: O(n)
    Space Complexity: O(n)
    where, n is the length of the string s
    
    Approach:
    1. maintain a hashset to keep the DNA sequences and result set to keep the repeated one
    2. iterate through the string, extract string of size 10 and check if they are either repeated or new (add to hashset)
    3. convert the result set as list to get the answer
    """
    
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        n = len(s)
        dnaSet = set(); resultSet = set()
        
        for i in range(n - 9):
            
            sequence = s[i: i + 10]
            if sequence in dnaSet:
                if sequence not in resultSet:
                    resultSet.add(sequence)
            else:
                dnaSet.add(sequence)
                
        return list(resultSet)

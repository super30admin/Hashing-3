# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Approach : 
# -Use hash map to store count of sequences. 
# -Add answer to the set and convert back it to list.
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        data = {}   
        n = len(s)
        
        if n <= 10:
            return []
#       If length of string is less than 10 than return empty list as answer.
        ans = set()
        
#       Iterate over every size 10 substring.
        for i in range(n - 9):
#           Take slice of size 10 substring
            temp = s[i:i+10]
#           Add slice to the dictionary and increament it's count
            data[temp] = data.get(temp, 0) + 1
#           If count of sequence is greater than 1, add it to the answer set
            if data[temp] > 1:
                ans.add(temp)
                
#       convert set to the list
        return list(ans)
                

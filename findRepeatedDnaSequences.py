#Rabin Karp
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        #prime why? reduce false positives
        prime = 101
        length = 10
        
        seen = set()
        output = set()
        
        #edge case
        if len(s)<10:
            return ""
        
        #for the first string with 10 letters
        def calculateHash(string):
            assert(len(string)==10)
            currSum = 0
            for j in range(length):
                currSum+= (prime**j)*ord(string[j])
            return currSum
        
        #update hash => previous value - (dropValue), dropValue is currently raised to zero, now the powers have to come down by one, and the added index should be raised to the prime raised to length-1
        def updateHashValue(prevValue, dropIndex, addIndex):
            return (prevValue - ord(s[dropIndex]))//prime + ord(s[addIndex])*prime**(length-1)
        
        hashValue = calculateHash(s[:10])
        seen.add(hashValue)
        
        for i in range(1, len(s)-9):
            hashValue = updateHashValue(hashValue, i-1, i+length-1)
            if hashValue in seen:
                output.add(s[i:i+length])
            else:
                seen.add(hashValue)
        return list(output)

# Time: O(N-L)
# Space: O(N-L)

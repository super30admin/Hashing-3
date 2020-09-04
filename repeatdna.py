# Time complexity - O((N-W)W) where N is the length of string, W is the length of window. 
#                                   (N-W) is the start point of string comparison
#                                   W is the length of window substring
# Space complexity - O((N-W)W)  
# Did this solution run on leetcode? - yes
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        allSubs = set()
        result = set()
        n = len(s)
        W = 10 # window size
        
        for i in range(n-W+1):
            subString = s[i:i+W]
            if subString in allSubs:
                result.add(subString)
                continue
            allSubs.add(subString)
    
        return result


# Time complexity - O(N-L+1)
# Space complexity - O(N-L)
# Did this solution run on leetcode?- yes
# STEPS (Leetcode solution 2):
# Keep a sliding window and calculating the hash for a subsequence.
# Compare the hash value on the subsequence with the target.
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        L = 4
        W = 10
        n = len(s)
        runningHash = 0
        seq_mapping = {'A': 0, 'C': 1, 'G': 2, 'T': 3}
        existingHash, result = set(), set()
        
        for start in range(n-W+1):
            if start == 0:
                # calculate the runnning hash value.
                for i in range(start, start+10):
                    runningHash = runningHash*L + seq_mapping[s[i]]
            else:
                runningHash = runningHash*L - seq_mapping[s[start-1]]*pow(L,W) + seq_mapping[s[start+9]]
            
            if runningHash in existingHash:
                result.add(s[start:start+10])
            
            existingHash.add(runningHash)
        
        return result

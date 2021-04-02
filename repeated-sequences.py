# TIME COMPLEXITY: O(N)
# SPACE COMPLEXITY: O(N)
class Solution:
    def findRepeatedDnaSequences(self, s):
        # Initialize a dictionary to hold the substrings seen so far
        count = dict()
        result = []
        # Iterate over all 10 char long substrings
        for i in range(0, len(s)-9):
            sub = s[i:i+10]
            # Check if a 10 char long substring is in the dictionary and marked as True
            # Add to result only if it occurs more than twice
            if sub in count and count[sub]:
                result.append(sub)
                count[sub] = False
            else:
                count[sub] = True
        return result

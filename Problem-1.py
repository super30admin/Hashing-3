#Approach
# Start with 2 pointers find start with i,j =0 and fing the 10 length string and calculate the rolling hash and itertae the j and calculate the rolloing hash if rolling hash is present add in the result else move ahead


#Complexities
#Time : O(n)
# Space: O(n)

from typing import List

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        result = set()
        subStrings = set()
        rollingHash = 0
        hashValue = {"A": 1, "C": 2, 'G': 3, 'T': 4}
        for i in range(len(s)):
            rollingHash = rollingHash * 4 + hashValue[s[i]]

            if i == 9:
                if rollingHash not in subStrings:
                    subStrings.add(rollingHash)
                else:
                    result.add(s[i - 9:i + 1])
            elif i >= 10:
                rollingHash = rollingHash - (4 ** 10 * hashValue[s[i - 10]])
                if rollingHash not in subStrings:
                    subStrings.add(rollingHash)
                else:
                    result.add(s[i - 9:i + 1])

        return list(result)






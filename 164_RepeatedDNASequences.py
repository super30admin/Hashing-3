'''
Accepted on leetcode(187)
time -O(N)
space - O(N)
'''


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        # declare 2 hashset's, one for adding all unique strings and another 'result' to add if some string repeats.
        allStrings = set()
        result = set()

        # iterate over substring and generate all substrings of length 10 and check if they exist in allStrings, if it exists then add them to result and if doesnt then add to allStrings.
        for i in range(len(s) - 9):
            if s[i:i + 10] in allStrings:
                result.add(s[i:i + 10])
            allStrings.add(s[i:i + 10])

        # convert the result to list and return.
        return list(result)
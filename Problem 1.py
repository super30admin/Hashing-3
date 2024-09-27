import collections


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        # making a diction which will have values as integers
        dct = collections.defaultdict(int)
        ans = []
        # iterate over the entire string with window of 10 characters and upadate the count of thesubstring in the dictionary
        for ss in range(len(s) - 9):
            dct[s[ss:ss + 10]] += 1

        # if the count of any substring in the dictionary is greater than 1 then append it to ans
        for i, c in dct.items():
            if c > 1:
                ans.append(i)
        return ans
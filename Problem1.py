"""
1. We always check for a window of size 10.
2. We maintain a hashmap to check if the current 10-length DNA sequence has been seen before.
3. If the current 10-length DNA sequence has been seen before, we add it to the result.

TC: O(N-10) * O(10) = O(N)
SC: O(N-10) * O(10) = O(N)

"""

class Solution(object):
    def findRepeatedDnaSequences(self, s):
        n = len(s)
        cnt = defaultdict(int)
        ans = []

        for i in range(n - 9):
            dna = s[i:i+10]
            cnt[dna] += 1
            if cnt[dna] == 2:
                ans.append(dna)

        return ans
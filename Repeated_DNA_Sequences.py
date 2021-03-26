# Created by Aashish Adhikari at 9:50 PM 3/24/2021
'''
Time Complexity:
O(n)

Space Complexity:
O(n-10) ~ O(n) for the hash set.
'''

class Solution(object):

    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """

        sol = set()
        hs = set()

        for idx in range(0, len(s)-10+1): # O(n)
            if s[idx:idx+10] not in hs:
                hs.add(s[idx:idx+10])
            else:
                sol.add(s[idx:idx+10])

        return list(sol)


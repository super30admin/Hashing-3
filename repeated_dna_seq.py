"""
Approach1: sliding window. A window of size 10. once the window is formed keep adding element from right and removing
from left.
TC: O 10*(n)

Approach2: rolling hash. Allows for efficient computation of hash values for repeated substrings by reusing computations
 from previous substrings. It updates the hash value incrementally when sliding the window of a fixed size
 (e.g., 10 characters in the DNA sequence problem)
 For the first 9 characters also, the rolling hash is added to the visited set. After that the rolling hash happens for
  10 characters long. Repeated hash value happens only if there is an exact match of the string (the number of characters
   should also be same).
 TC: O(n)
"""

from collections import deque


class Solution_rollinghash:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:

        hmap = {'A': 1, 'C': 2, 'G': 3, 'T': 4}

        rollhash = 0
        visited = set()
        ans = set()
        position_factor = pow(len(hmap), 10)

        for idx in range(len(s)):
            incoming_ch = s[idx]
            # calcuate
            rollhash = (rollhash * len(hmap)) + hmap[incoming_ch]

            # check when 10 ch are formed
            if idx >= 10:
                outgoing_ch = s[idx - 10]
                # contribution of outgoing ch
                rollhash = rollhash - (position_factor * hmap[outgoing_ch])

            if rollhash in visited:
                ans.add(s[idx - 9:idx + 1])
            else:
                visited.add(rollhash)

        return list(ans)


class Solution_approach1:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:

        # brute force
        idx = 0
        # to track the occurrence of the set
        visited = set()
        # take ans as set as there could be duplicates in the answer
        ans = set()
        n = len(s)
        q = deque()
        while idx < n:
            ch = s[idx]
            q.append(ch)
            # check if the lenght of the string is 10
            if len(q) == 10:
                curr_seq = "".join(q)
                if curr_seq in visited:
                    ans.add(curr_seq)
                else:
                    visited.add(curr_seq)
                # remove the leftmost element
                q.popleft()

            idx += 1

        return list(ans)

from typing import List


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        """
            https://leetcode.com/problems/repeated-dna-sequences/
            Time Complexity - O(n)
            Space Complexity - O(n(
        """
        seq = set()
        result = set()
        for i in range(len(s) - 10 + 1):
            cur_str = s[i:i + 10]
            if cur_str in seq:
                result.add(cur_str)
            seq.add(cur_str)
        return list(result)


if __name__ == '__main__':
    print(Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
    print(Solution().findRepeatedDnaSequences("AAAAAAAAAAA"))

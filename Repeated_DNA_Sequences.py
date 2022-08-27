# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> list[str]:
        dictu1 = set()
        dictu2 = set()
        result = []
        for i in range(len(s)):
            word = s[i:i + 10]
            if word in dictu1 and word not in dictu2:
                result.append(word)
                dictu2.add(word)
            dictu1.add(word)
        return result


print(Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))


# from collections import defaultdict
#
#
# class Solution:
#     def findRepeatedDnaSequences(self, s: str) -> list[str]:
#         dictu = defaultdict(int)
#         result = []
#         for i in range(len(s)):
#             word = s[i:i+10]
#             if word in dictu and dictu[word] == 1:
#                 result.append(word)
#             dictu[s[i:i+10]] += 1
#         return result
#
#
# print(Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))

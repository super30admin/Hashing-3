class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        # # Hashset approach
        # visited = set()
        # result = set()
        # if len(s) < 10:
        #     return []
        # st = 0
        # ed = 10
        # while ed <= len(s):
        #     temp = s[st:ed]
        #     if temp in visited:
        #         result.add(temp)
        #     visited.add(temp)
        #     ed += 1
        #     st += 1
        # return result

        # Rabin karp algorithm
        # Also called as rolling hash algortihm
        # Time O(n)
        # Space O(n)
        offset = 4 ** 10
        visited = set()
        result = set()
        hashh = 0
        if len(s) < 10:
            return []
        rabin = {'A': 1, 'G': 2, 'C': 3, 'T': 4}
        for i in range(len(s)):
            hashh = hashh * 4 + rabin[s[i]]
            if i > 9:
                hashh = hashh - (rabin[s[i - 10]] * offset)
            temp = s[i - 9:i + 1]
            # print(temp, hashh)
            if hashh in visited:
                result.add(temp)
            visited.add(hashh)
        return result








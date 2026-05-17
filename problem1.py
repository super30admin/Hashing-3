# problem 1
# https://leetcode.com/problems/repeated-dna-sequences/

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        L, n = 10, len(s)
        if n <= L:
            return []
        a = 4
        aL = pow(a, L)
        to_int = {"A": 0, "C": 1, "G": 2, "T": 3}
        nums = [to_int.get(s[i]) for i in range(n)] # convert to num array
        h = 0 
        seen = set()
        output = set()

        for start in range(n-L+1):
            if start!=0:
                h = h * a - nums[start-1] * aL + nums[start+L-1]
            else:
                for i in range(L):
                    h = h*a + nums[i]
            if h in seen:
                output.add(s[start:start+L])
            seen.add(h)
        return list(output)
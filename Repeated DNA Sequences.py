#  Time Complexity : O(n) 
#  Space Complexity : O(n) 
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code finds all repeated DNA sequences of length 10 in a string s using rolling hash. Each character (A, C, G, T) is mapped to a number, and a base-4 rolling hash is maintained to represent the last 10 characters. If a hash value is seen again, the corresponding substring is added to the result set, ensuring duplicates are captured efficiently in O(n) time.
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        n = len(s)
        allSeq = set()
        result = set()

        hashVal = 0
        map_char = {'A': 1, 'C': 2, 'G': 3, 'T': 4}
        posFac = 4**10

        for i in range(n):
            hashVal = hashVal * 4 + map_char[s[i]]

            if i >= 10:
                hashVal -= posFac * map_char[s[i - 10]]

            if i >= 9:
                if hashVal in allSeq:
                    result.add(s[i - 9: i + 1])
                else:
                    allSeq.add(hashVal)
        
        return list(result)

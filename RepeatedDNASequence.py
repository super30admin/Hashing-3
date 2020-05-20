'''

Solution:
1.  Implemented an extension of Rabin Karp's Algorithm where the difference here is instead of having one sub-pattern
    to search, we have on an average, k - sub-patterns to check with the main string.
2.  Getting a new Hash for each new continuing sub-string happens in O(1) time and also tries to maintain the
    position information of each character in the sub-string by using polynomial coefficients.

Time Complexity:    O(n * k) -- n is the length of the string and k is the average number of already existing DNA
                                sequences at each instant.
Space Complexity:   O(k) for the HashSet containing already existing DNA sequences.
'''


class Solution:

    def __getNewHash(self, s: str, currentId: int, L: int, oldHash: 'long', basePrime: int) -> 'long':

        #   constant time Rabin Karp's idea for genrating new Hash
        oldFirstCoeff = ord(s[currentId - L]) - ord('A') + 1
        newLastCoeff = ord(s[currentId]) - ord('A') + 1

        newHash = oldHash - (oldFirstCoeff * (basePrime ** (L - 1)))
        newHash *= basePrime
        newHash += newLastCoeff

        return newHash

    def findRepeatedDnaSequences(self, s: str) -> List[str]:

        #   initializations and edge case checks
        L = 10
        n = len(s)
        if (s == None or n < 10):
            return []

        finalResult = set()
        hashSequenceMap = {}
        basePrime = 3
        oldHash = 0

        #   first L-length sub-pattern Hash calculation
        for i in range(L):
            power = L - i - 1
            coefficient = ord(s[i]) - ord('A') + 1
            oldHash += ((basePrime ** power) * coefficient)

        hashSequenceMap[oldHash] = set([s[:10]])

        #   for the next n - L hash calculations and comparisons
        for i in range(L, n):
            newHash = self.__getNewHash(s, i, L, oldHash, basePrime)
            oldHash = newHash
            s2 = s[i - L + 1: i + 1]

            if (newHash in hashSequenceMap):

                existingSets = hashSequenceMap[newHash]

                if (s2 in existingSets):
                    finalResult.add(s2)

                else:
                    hashSequenceMap[newHash].add(s2)

            else:
                hashSequenceMap[newHash] = set([s2])

        #   return the final resulting repeating DNA sequences
        return list(finalResult)
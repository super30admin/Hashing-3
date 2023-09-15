from typing import List


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        '''
        Find repeated DNA sequences in the given string using a rolling hash approach.
        Time complexity --> O(N), where N is the length of the input string
        Space complexity --> O(N) due to the sets used for storing hash values and results.
        :param s: Input string
        :return: List of repeated DNA sequences
        '''
        L = 10  # Length of the DNA sequence
        base = 4  # Number of possible characters (A, C, G, T)
        mod = 10**9 + 7  # Modulo value to prevent integer overflow

        # Dictionary to convert characters to numerical values (1 to 4)
        char_to_num = {'A': 1, 'C': 2, 'G': 3, 'T': 4}

        # Initialize rolling hash variables
        curr_hash = 0
        rolling_hash = set()
        result = set()

        # Calculate hash value for the first DNA sequence
        for i in range(L):
            curr_hash = (curr_hash * base + char_to_num[s[i]]) % mod

        rolling_hash.add(curr_hash)

        # Iterate through the rest of the string
        for i in range(1, len(s) - L + 1):
            # Calculate hash value using rolling hash formula
            curr_hash = (
                curr_hash * base + char_to_num[s[i + L - 1]] - char_to_num[s[i - 1]] * pow(base, L, mod)) % mod

            # If hash value is already in rolling_hash, add to the result
            if curr_hash in rolling_hash:
                result.add(s[i:i+L])
            else:
                rolling_hash.add(curr_hash)

        return list(result)

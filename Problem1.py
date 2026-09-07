# Problem1  Repeated DNA Sequences (https://leetcode.com/problems/repeated-dna-sequences/)
# Time Complexity: O(n),We go through the string exactly once with a single loop. At each step we only do a fixed amount of work, one multiply, one add, sometimes one subtract and a set lookup plus insert which is O(1) on average. None of that work grows as the window slides, so the total time grows in a straight line with the length of the string.
# Space Complexity: O(n),In the worst case almost every 10 letter window is different from every other one, so allseq ends up storing close to one fingerprint number per window and there are roughly n such windows. result can also hold up to that many repeated sequences in the worst case. So the extra memory used also grows in a straight line with n.
# Approach:
# We only have 4 possible letters, A, C, G, T, so we can treat any 10 letter window as a number written in base 4, the same way normal numbers are written in base 10.
# Each letter gets its own digit value and we build up a number by reading letters left to right, shifting everything over each time a new letter comes in, exactly like building 123 digit by digit as number = number * 10 + new_digit.
# Since the window length never changes, two different sets of 10 letters can never produce the same number, so this number works as a fingerprint for that exact sequence. 
#Instead of rebuilding this fingerprint from scratch every time the window slides forward by one letter, we update it in place add the new letter's value in, then subtract out the contribution of the letter that just fell out of the window.
# We keep every fingerprint we've built so far in a set. Once we have a full 10 letter window, if its fingerprint is already in that set, we know for certain those exact 10 letters showed up earlier, so we save the actual text into our results.

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        n = len(s)          # total number of letters in the string, tells us how far to loop
        allseq = set()          # stores the fingerprint number of every full window we've already seen
        result = set()      # stores the actual repeated 10 letter pieces of text, set so duplicates never pile up

        hash_val = 0        # our running fingerprint number, starts empty since we haven't read any letters yet
        map_char = {'A': 1, 'C': 2, 'G': 3, 'T': 4}     # gives each letter a digit so we can treat the string like a base 4 number
        posfac = 4**10          # the place value of a digit once it has been shifted left 10 times, needed later to cancel out the oldest letter in the window

        for i in range(n):          # walk through the string one letter at a time
            hash_val = hash_val * 4 + map_char[s[i]]
            # shift everything we've built so far one spot to the left by multiplying by 4
            # (base 4 since we only have 4 possible letters), then drop the new letter's
            # value into the freshly opened last spot, same idea as number * 10 + digit

            if i >=10:
                hash_val -= posfac * map_char[s[i-10]]
                # once we've read past 10 letters, our number secretly represents 11 letters, one too many, so we remove the oldest one, s[i-10], by subtracting out exactly how much it was contributing using its known place value posfac
            
            if i>=9:
                # this only makes sense once we've actually built a full 10 letter window,
                # since positions are 0 indexed, having 10 letters means i is at least 9
                if hash_val in allseq:
                    # this exact number showed up before, meaning the exact same 10 letters
                    # occurred earlier in the string, so this is a genuine repeat
                    result.add(s[i-9:i+1])
                    # grab the actual 10 letter text, from 9 positions back through here,
                    # and save it since this is what the problem actually wants returned
                else:
                    allseq.add(hash_val)
                    # first time seeing this particular 10 letter sequence, just remember
                    # its fingerprint so we can catch it if it ever shows up again

        return list(result)  # hand back all the repeated sequences we found, order does not matter
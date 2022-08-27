# Time Complexity : O(m*n); m --> no. of users; n --> no.of songs
# Space Complexity : O(m+n) m --> no.of genres; n --> no.of songs
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
from collections import defaultdict


class Solution:
    def favouriteGenre(self, user, genre):
        result = defaultdict(list)
        temp_genre = defaultdict(list)
        for i in genre:
            for j in genre[i]:
                temp_genre[j].append(i)
        for i in user:
            maxi = 0
            count = defaultdict(int)
            for j in user[i]:
                for k in temp_genre[j]:
                    count[k] += 1
                    if count[k] > maxi:
                        result[i] = [k]
                        maxi = count[k]
                    elif count[k] == maxi:
                        result[i].append(k)
        return result


print(Solution().favouriteGenre(
    {"David": ["song1", "song2", "song3", "song4", "song8"], "Emma": ["song5", "song6", "song7"]},
    {"Rock": ["song1", "song3"], "Dubstep": ["song7"], "Techno": ["song2", "song4"], "Pop": ["song5", "song6"],
     "Jazz": ["song8", "song9"]}))

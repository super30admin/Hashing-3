# Time Complexity : O(MN)
# Space Complexity : O(M)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using HashMaps

from collections import defaultdict


def favoriteGenres(userSongs, songGenres):
    song_list = defaultdict()
    res = defaultdict()
    for key, val in songGenres.items():
        for i in val:
            song_list[i] = key

    for key, val in userSongs.items():
        maxcount = 0
        count_dict = {}
        for i in val:
            if i in song_list:
                if song_list[i] not in count_dict:
                    count_dict[song_list[i]] = 1
                else:
                    count_dict[song_list[i]] += 1
                    maxcount = max(maxcount, count_dict[song_list[i]])
        for k, v in count_dict.items():
            if count_dict[k] == maxcount:
                if key not in res:
                    res[key] = [k]
                else:
                    res[key].append(k)
    return res


userSongs = {
    "David": ["song1", "song2", "song3", "song4", "song8", "song10"],
    "Emma": ["song5", "song6", "song7"]
}

songGenres = {
    "Rock": ["song1", "song3", "song10"],
    "Dubstep": ["song7"],
    "Techno": ["song2", "song4"],
    "Pop": ["song5", "song6"],
    "Jazz": ["song8", "song9"]
}
print(favoriteGenres(userSongs, songGenres))
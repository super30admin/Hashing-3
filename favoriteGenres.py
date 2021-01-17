#Time Complexity : O(k*m*n) where k is the number of uses and m is the number of songs and n is the number of genres
#Space Complexity : O(m*n) where m is the number of songs and n is the number of genres
#Did this code successfully run on Leetcode : Yes

import collections
def favGenre(userSongs, songGenres):
    result = collections.defaultdict(list)
    songToGenre = {}

    for genre, songs in songGenres.items():
        for song in songs:
            songToGenre[song] = genre

    for user, songs in userSongs.items():
        userGenreCount = {}
        maxCount = 0
        for song in songs:
            userGenreCount[songToGenre[song]] = userGenreCount.get(songToGenre[song], 0) + 1
            maxCount = max(maxCount, userGenreCount[songToGenre[song]])

        for genre, c in userGenreCount.items():
            if c == maxCount:
                result[user].append(genre)

    return result





userSongs = {
   "David": ["song1", "song2", "song3", "song4", "song8"],
   "Emma":  ["song5", "song6", "song7"]
}

songGenres = {
   "Rock":    ["song1", "song3"],
   "Dubstep": ["song7"],
   "Techno":  ["song2", "song4"],
   "Pop":     ["song5", "song6"],
   "Jazz":    ["song8", "song9"]
}

print(favGenre(userSongs, songGenres))

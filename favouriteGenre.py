"""
TC- O(MN)+ O(kMN)+ O(M) = build SongToGenre + iterating over users and songs(WC all genre and all songs)
here m-#genres, n-#songs, k-#users
Asymptotically O(kMN) is TC 

SC- O(MN) songToGenre map

create a song to Genre map where key is songs , value is genres and then for each user genre: count map and return max.

"""

from collections import defaultdict


def favouriteGenres(userSongs, songGenres):
    songsTogenre = {}
    res= defaultdict(list)
    for genre in songGenres: #songs to genre map creation 
        songs = songGenres[genre]
        for song in songs:
            songsTogenre[song] = genre
    for user in userSongs: #O(Kmn)
        songli = userSongs[user]
        temp = defaultdict(int)
        maxValue = float('-inf')
        maxGenre = []
        for s in songli:
            g = songsTogenre[s]
            temp[g] += 1
            maxValue = max(maxValue, temp[g])
        for g in temp:
            if temp[g] == maxValue:
                maxGenre.append(g)
        res[user] = maxGenre
    return res


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
print(favouriteGenres(userSongs, songGenres))

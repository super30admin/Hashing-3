import collections
def favoritegenre(usermap, genremap):
    # res = collections.defaultdict(list)
    res = {}
    songtogenre = {}
#     create song to genre map
    for genre in genremap:
        for song in genremap[genre]:
            songtogenre[song] = genre
#     for each user find the most listened genre
    for user in usermap:
        maxval = 0
        freqmap = {}
        res[user] = []
        for song in usermap[user]:
            genre = songtogenre[song]
            freqmap[genre] = freqmap.get(genre,0)+1
            maxval = max(maxval, freqmap[genre])
        
        for genre in freqmap:
            if freqmap[genre] == maxval:
                res[user].append(genre)
            
    return res 


userSongs = {
    "David": ["song1", "song2", "song3", "song4", "song8"],
    "Emma": ["song5", "song6", "song7"]
}

songGenres = {
    "Rock": ["song1", "song3"],
    "Dubstep": ["song7"],
    "Techno": ["song2", "song4"],
    "Pop": ["song5", "song6"],
    "Jazz": ["song8", "song9"]
}

res = favoritegenre(userSongs, songGenres)
print(res)
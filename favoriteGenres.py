from collections import defaultdict
def favoriteGenres(userSongs, songGenres):
    res = defaultdict(int)
    for user in userSongs:
        songs = userSongs[user]
        genreCnt = defaultdict(int)
        for song in songs:
            for genre in songGenres:
                if song in songGenres[genre]:
                    genreCnt[genre] += 1
        print(genreCnt)
        res[user] = [key for key, val in genreCnt.items() if val == max(genreCnt.values())]    
                    
    return dict(res)

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

print(favoriteGenres(userSongs, songGenres))
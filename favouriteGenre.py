def favoriteGenre(userMap, genreMap):
    songtogenre={}

    for genre,songs in genreMap.items(): #O(n)
        for song in songs:
            songtogenre[song]=genre
    
    res={}

    for user,songs in userMap.items(): #O(m) - so in total O(m*n) (n from line 14)
        res[user]=[]
        max_count=0
        countmap={}
        for song in songs: #O(n)
            genre=songtogenre[song]
            countmap[genre]=countmap.get(genre,0)+1
            max_count=max(max_count,countmap[genre])

        for genre,count in countmap.items():
            if count==max_count:
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

res = favoriteGenre(userSongs, songGenres)
print(res)

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
genreSongs = {}
for key, val in songGenres.items():
    for song in val:
        genreSongs[song]=key

userGenre = {}
for user, songs in userSongs.items():
    topGenre = {}
    maxGenre = ""
    maxCount = 0
    for song in songs:
        genre = genreSongs[song]
        if genre not in topGenre:
            topGenre[genre]=0
        topGenre[genre] += 1
        maxCount = max(maxCount, topGenre[genre])
        
    for genre, count in topGenre.items():
        if count == maxCount:
            if user not in userGenre:
                userGenre[user] = []
            userGenre[user].append(genre) 
print(userGenre)
    
        
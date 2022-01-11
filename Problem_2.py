def findGenre(userMap, genreMap):
    result = {}
    songToGenre = {}
    for genre in genreMap.keys():
        songs = genreMap[genre]
        for song in songs:
            songToGenre[song] = genre
   
    for user in userMap.keys():
        result[user] = list()
        countMap = {}
        songs = userMap[user]
        maxi = 0
        for song in songs:
            if song in songToGenre:
                genre = songToGenre[song]
                countMap[genre] = countMap.get(genre, 0) + 1
                maxi = max(maxi, countMap[genre])
        for genre in countMap:
            if countMap[genre] == maxi:
                result[user].append(genre)
    return result
        

userSongs = {"David": ["song1", "song2", "song3", "song4", "song8"],
"Emma": ["song5", "song6", "song7"]}
songGenres = {
"Rock": ["song1", "song3"],
"Dubstep": ["song7"],
"Techno": ["song2", "song4"],
"Pop": ["song5", "song6"],
"Jazz": ["song8", "song9"]
}

print(findGenre(userSongs, songGenres))

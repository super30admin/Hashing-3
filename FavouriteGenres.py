def favoritegenre(userMap, genreMap):
    songToGenreMap = {}
    for genre in genreMap:
        for song in genreMap[genre]:
            songToGenreMap[song] = genre

    result = {}

    for user in userMap:
        result[user] = []
        songs = userMap[user]
        frqMap = {}
        max_count = 0

        for song in songs:
            genre = songToGenreMap.get(song)
            frqMap[genre] = frqMap.get(genre, 0) + 1
            max_count = max(max_count, frqMap[genre])

        for genre in frqMap:
            if frqMap[genre] == max_count:
                result[user].append(genre)

    return result


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

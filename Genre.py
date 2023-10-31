def favoritegenre(userMap, genreMap):
    result={}
    song_map={}
    for genre in genreMap:
        for song in genreMap[genre]:
            song_map[song]=genre
    for user in userMap:
        count_map={}
        maxi=0
        for song in userMap[user]:
            if song_map[song] in count_map:
                count_map[song_map[song]]+=1
                maxi=max(maxi, count_map[song_map[song]])
            else:
                count_map[song_map[song]]=1
        result[user]=[]
        for genre in count_map:
            if count_map[genre]==maxi:
                result[user].append(genre)
    return result

if __name__ == "__main__":
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

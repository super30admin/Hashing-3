def favouriteGenres(userSongs, songGenres):
    songDir = {}
    res = {}
    # building the SingTogenre Map -- to get O(1)
    for genre in songGenres.keys():
        #print (genre)
        for s in songGenres[genre]:
            songDir[s] = genre
    # buikdin the my Artist result
    print(songDir)
    for us in userSongs:
        mx = 0
        user = {}
        for s in userSongs[us]:
            if songDir[s] not in user:
                user[songDir[s]] = 0
            user[songDir[s]] += 1
            mx = max(mx, user[songDir[s]])
        temp = []
        # get the max count of favorite genree
        for k in user:
            if user[k] == mx:
                temp.append(k)
        res[us] = temp
    #print(res)



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
def favGenre(userSongs, songGenres):
    """
     TC:O(m*n*l) , m=len of genre, n= len of songs, l=len of users
     SC:(m*n), {song:genre} hashmap
     https://leetcode.com/discuss/interview-question/373006
    """
    songMapGenre = {}
    res = defaultdict(list)
    # mapping each song to genre
    for key in songGenres:
        songs = songGenres[key]
        for song in songs:
            songMapGenre[song] = key
    print(songMapGenre)
    for user in userSongs:
        songlist = userSongs[user]
        temp = defaultdict(int)
        maxval = -inf
        maxgenre = []
        for songg in songlist:
            gen = songMapGenre[songg]
            temp[gen] += 1
            maxval = max(maxval, temp[gen])
        for gen in temp:
            if temp[gen] == maxval:
                maxgenre.append(gen)
        res[user] = maxgenre
    print(res)
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

favGenre(userSongs, songGenres)

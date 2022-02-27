#Time complexity : O(Users * Songs)
#Space complexity : O(Users * Songs)


def favouriteSongs(userSongs,songGenres):
    result = {}
    genremap = {}

    for genre in songGenres:
        for song in songGenres[genre]:
            genremap[song] = genre

    for user in userSongs:
        # print(userSongs)
        usermap = {}
        _max = 0
        for song in userSongs[user]:
            usermap[genremap[song]] = usermap.get(genremap[song], 0) + 1
            _max = max(_max, usermap[genremap[song]])

        result[user] = []

        for genres in usermap:
            if usermap[genres] == _max:
                result[user].append(genres)

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

print(favouriteSongs(userSongs, songGenres))

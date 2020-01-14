'''
Amazon online assessment question
time - O(S*G + U*S)
space - O(S)
'''
def FavoriteGenres(userSongs, songGenres):
    songs =  {}
    result = {}

    # creating songs hashmap which contains song to genre connection.
    for genre in songGenres.keys():
        for song in songGenres[genre]:
            songs[song] = genre


    # iterate through each user
    for user in userSongs.keys():
        # maintain a maxGenre count for each user and a genreToCount hashmap.
        maxGenre = 0
        GenreToCount = {}

        # iterate through songs of each user and find it's corresponding genre from songs hashmap
        # and if the genre is repeated more than once increase the count in genreToCount hashmap
        # and also maintain a maxCount which contains max songs belongs to a genre.
        for song in userSongs[user]:
            if songs[song] in GenreToCount:
                GenreToCount[songs[song]] += 1
            else:
                GenreToCount[songs[song]] = 1
            maxGenre = max(maxGenre, GenreToCount[songs[song]])

        # iterate through genreToCount for each user and if the maxCount matches the genre add that to result set.
        for genre in GenreToCount.keys():
            if GenreToCount[genre] == maxGenre:
                if user in result:
                    result[user].append(genre)
                else:
                    result[user] = [genre]

    return result


# test case 1
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

print(FavoriteGenres(userSongs,songGenres))

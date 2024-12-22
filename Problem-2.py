#Approach
# Do the reverse mapping of the songto genre and find the frequency of song of each user using the song to genre. append the max frequency genre to the result

#Complexities
#Time: O(U*S) U:Users S:Songs
#Space:O(S+U)



def favorite_genre(userSongs,genresSong):
    songToGenre = dict()

    for genre in genresSong:
        for song in genresSong[genre]:
            songToGenre[song] = genre

    result =dict()
    freqMap = dict()
    for user in userSongs:
        maxCount = float("-inf")
        result[user]=[]
        for songs in userSongs[user]:
            freqMap[songToGenre[songs]] = freqMap.get(songToGenre[songs],0)+1
            if maxCount < freqMap[songToGenre[songs]]:
                result[user].clear()
                result[user].append(songToGenre[songs])
            elif maxCount==freqMap[songToGenre[songs]]:
                result[user].append(songToGenre[songs])

            maxCount = max(maxCount,freqMap[songToGenre[songs]])
    return  result
















# Test input
user_songs = {
    "David": ["song1", "song2", "song3", "song4", "song8"],
    "Emma": ["song5", "song6", "song7"]
}

genres_songs = {
    "Rock": ["song1", "song3"],
    "Dubstep": ["song7"],
    "Techno": ["song2", "song4"],
    "Pop": ["song5", "song6"],
    "Jazz": ["song8", "song9"]
}

print(favorite_genre(user_songs,genres_songs))
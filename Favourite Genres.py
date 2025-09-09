#  Time Complexity : O(U * S) where U is number of users and S is number of songs
#  Space Complexity : O(S) 
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code determines each user’s favorite music genre(s) based on the songs they listen to. It first builds a songToGenreMap from the given genreMap, then for each user counts how many songs they listened to per genre. Finally, it tracks the maximum count and stores the genre(s) with the highest frequency for each user in the result dictionary.

def favoriteGenre(userMap, genreMap):
    songToGenreMap = {}
    result = {}
    for genre in genreMap:
        for song in genreMap[genre]:
            songToGenreMap[song] = genre
    
    for user in userMap:
        result[user] = []
        songs = userMap[user]
        mapFrq = {}
        max_count = 0

        for song in songs:
            genre = songToGenreMap.get(song)
            mapFrq[genre] = mapFrq.get(genre, 0) + 1 

            if max_count < mapFrq[genre]:
                result[user].clear()
                result[user].append(genre)
            elif max_count == mapFrq[genre]:
                result[user].append(genre)
            max_count = max(max_count, mapFrq[genre])
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

res = favoriteGenre(userSongs, songGenres)
print(res)
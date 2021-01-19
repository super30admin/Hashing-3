from collections import defaultdict
def favoriteGenres(userSongs, songGenres):
    results = defaultdict(int)
    for user in userSongs:
        songs = userSongs[user]
        genreCount = defaultdict(int)
        for song in songs:
            for genre in songGenres:
                if song in songGenres[genre]:
                    genreCount[genre] += 1

        results[user] = [key for key, val in genreCount.items() if val == max(genreCount.values())]   
  

#we use hashmaps to solve this problem as taught in class
#Time compleity: O(n)
#Space Complexity:  O(2n)
from collections import defaultdict
def favgen(userMap, genreMap):
    result = defaultdict(list())
    songsToGenre = defaultdict(list())
    for genre in genreMap:
        songs = genreMap[genre]
        if (songs is not None):
            for song in songs:
                songsToGenre[song] = genre
    count = dict()
    for user in userMap:
        count = dict()
        max = 0
        result[user] = list()
        songs = userMap[user]
        for song in songs:
            genre = songsToGenre[song]
            currcount = count[genre]
            currcount = currcount + 1
            max = max(max, currcount)
            count[genre] = currcount
        for genre in count:
            if count[genre] == max:
                result[user] = genre
    return result


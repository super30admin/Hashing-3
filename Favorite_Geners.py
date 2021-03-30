"""
Time Complexity : O(mn) for buolding the map and O(kmn) for iterating over users and songs(worst case all songs for all users)
here m- no. of genres, n- songs in each genre, k- no. of users
Space Complexity : O(mn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach:
Here, we first create a map to map all songs to their respective genres. Afterwrds, we iterate over all their users and their songs,
fetch the genre of songs from the previously made map, keep track of maximum number. After iterating through the songs, we check which
genre had the maximum count. Hence, we add that to our result.
"""

from collections import defaultdict


def favouriteGenres(userSongs, songGenres):
    songs = {}
    result = defaultdict(list)
    for g in songGenres:
        tempList = songGenres[g]
        for song in tempList:
            songs[song] = g
    for user in userSongs:
        tempList = userSongs[user]
        tempDict = defaultdict(int)
        maxValue = float('-inf')
        maxGenre = []
        for s in tempList:
            g = songs[s]
            tempDict[g] += 1
            maxValue = max(maxValue, tempDict[g])
        for g in tempDict:
            if tempDict[g] == maxValue:
                maxGenre.append(g)
        result[user] = maxGenre
    return result


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

"""
Time Complexity : O()
Space Complexity : O()
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
1. make map of song in genre
2. make mao of each user with no of those songs as value
3. calculate max go through map and append to res where val == max

"""


def favouriteGenres(userSongs, songGenres):
    songDir = {}
    res = {}
    for genre in songGenres:
        for s in songGenres[genre]:   
            songDir[s] = genre
    
    for us in userSongs:
        mx = 0
        user = {}
        for s in userSongs[us]:
            if songDir[s] not in user:
                user[songDir[s]] = 0
            user[songDir[s]] += 1
            mx = max(mx, user[songDir[s]])
        temp = []
        for k in user:
            if user[k] == mx:
                temp.append(k)
        res[us] = temp
    print(res)
                
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
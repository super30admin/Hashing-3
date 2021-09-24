#Time complexity : O(MN) N:len(user) M:len(songs)
#space complexity : O(MN)
from collections import defaultdict
def favouriteGenres(userSongs, songGenres):
    song2genre = {}
    res = {}
    for genre, songs in songGenres.items():
        for song in songs:
            song2genre[song] = genre
            
    for user,songs in userSongs.items():
        maxi = 0
        userdict = defaultdict(int)
        for song in songs:
            userdict[song2genre[song]]+=1
            maxi =max(maxi,userdict[song2genre[song]])
        temp =[]
        for k,v in userdict.items():
            if v==maxi:
                temp.append(k)
        res[user] =temp
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

print(favouriteGenres(userSongs, songGenres))
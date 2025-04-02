#time:(user*songs*genre)
#space:(user*songs*genre)
from collections import defaultdict

def favorite_genres(userSongs, songGenres):
    genresong=defaultdict()
    #convert to songs ang genre mapping
    for genre, songs in songGenres.items():
        for song in songs:
            genresong[song]=genre
    
    userfavgenre= defaultdict(list)
    # create a map of user genre
    for user, songs in userSongs.items():
        mx=0
        genrecnt= defaultdict(int)
        for song in songs:
            if song in genresong:
                genrecnt[genresong[song]]+=1
                mx= max(mx,genrecnt[genresong[song]])
        res=list()
        for genre,cnt in genrecnt.items():
            if cnt== mx:
                res.append(genre)
        userfavgenre[user]=res
    return userfavgenre

# Example 1
userSongs1 = {
    "David": ["song1", "song2", "song3", "song4", "song8"],
    "Emma":  ["song5", "song6", "song7"]
}
songGenres1 = {
    "Rock":    ["song1", "song3"],
    "Dubstep": ["song7"],
    "Techno":  ["song2", "song4"],
    "Pop":     ["song5", "song6"],
    "Jazz":    ["song8", "song9"]
}

# Example 2
userSongs2 = {
    "David": ["song1", "song2"],
    "Emma":  ["song3", "song4"]
}
songGenres2 = {}

# Run driver
print("Example 1 Output:")
print(favorite_genres(userSongs1, songGenres1))

print("\nExample 2 Output:")
print(favorite_genres(userSongs2, songGenres2))

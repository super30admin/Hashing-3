"""
time : o(n*m), n - number of users, m - number of songs
space : o(m)
"""
from collections import defaultdict

def fav_genre(userSongs, songGenres):
    song_to_genres = {}

    for genre, song_list in songGenres.items(): #creating a mapping of song to genre for every song

        for song in song_list:
            song_to_genres[song] = genre

    #print(song_to_genres)
    res = {}
    for user,songs in userSongs.items(): #for each user find the count for each genre
        user_ct = defaultdict(int) #will m aintain count for each genre
        max_ct = 0 #max count to find the fav genre

        for s in songs:
            user_ct[song_to_genres[s]] += 1

            max_ct = max(max_ct, user_ct[song_to_genres[s]])

        genre_list = [] # list of favourite genre for each user
        for g, ct in user_ct.items():
            if ct == max_ct: #if ct for that genre is equal to max_ct, add it to result list 
                genre_list.append(g)
        res[user] = genre_list

    return(res)

#--------------driver code-------------#
userSongs = {"David": ["song1", "song2", "song3", "song4", "song8"],"Emma": ["song5", "song6", "song7"]}

songGenres = {"Rock": ["song1", "song3"],"Dubstep": ["song7"],"Techno": ["song2", "song4"],"Pop": ["song5", "song6"],"Jazz": ["song8", "song9"]}

print(fav_genre(userSongs, songGenres))    
    #print(user_ct)
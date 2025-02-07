# Time:O(m+s)*n/ genres + users * songs
# Space:O(s) songs
# leetcode:N/A
# Issues: line 22 genre_count

from collections import defaultdict

def favorite_genre(user_map, genre_map):
    song2genre = {}
    for genre in genre_map:
        songs = genre_map[genre]
        for song in songs:
            song2genre[song] = genre
            
            
    res = defaultdict(list)             
    
    for user in user_map:
        songs = user_map[user]
        
        genre_count = defaultdict(int) #
        
        for song in songs:
            if song in song2genre:
                g = song2genre[song]
                genre_count[g] +=1          # more than once
                
        if genre_count:
            ma = max(genre_count.values())
                
            for g,c in genre_count.items():
                if c == ma:                 # max counter
                    res[user].append(g)     # add it
                        
    return dict(res)
    
user_songs = {
    "David": ["song1", "song2", "song3", "song4", "song8"],
    "Emma": ["song5", "song6", "song7"]
}

song_genres = {
    "Rock": ["song1", "song3"],
    "Dubstep": ["song7"],
    "Techno": ["song2", "song4"],
    "Pop": ["song5", "song6"],
    "Jazz": ["song8", "song9"]
}

res = favorite_genre(user_songs, song_genres)
print(res)
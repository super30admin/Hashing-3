"""
// Time Complexity : O(M * N) #M -> userSongs, N -> songGenres
// Space Complexity : O(max(M,N)) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
"""
from collections import defaultdict

#Method1
"""
1. Using the songGenres map, create a reverse mapping of genre to song
2. For each user from the user song mapping
    - Create a mapping of genre and count for that user
        - Process the songs 
            - update the max variable based on count of genre of the song(from the map)
        - Process the genreCount map for each user and update the result based on comparing with max frequency
"""
def fav_genres(userSongs,songGenres):
    result = defaultdict(list)
    genre_song_map = {}
    for genre,songs in songGenres.items():
        for song in songs:
            genre_song_map[song] = genre
    
    for user,songs in userSongs.items():
        genre_count = defaultdict(int)
        max_count = float("-inf")
        for song in songs:
            genre_count[genre_song_map[song]]+=1
            max_count = max(genre_count[genre_song_map[song]],max_count)
        
        for genre,count in genre_count.items():
            if count == max_count:
                result[user].append(genre)
    
    return result

#MEthod2

"""
1. Format the input map to contain the values as set instead of list
2. For each user  (Create fav genre map)
    - For each songs list, we find intersecting songs with songs in genres
    and store the count of song for each genre
3. All we need to do is iterate over the fav genre map 
    - Fetch only the genres that match the maximum frequency of songs per each user
    - Update the result map for user with the genre of matching maximum count
4. Return result map
 """
def fav_genres(user_songs,song_genres):
    """
    desired stucture - {"genre1":genre_count,"genre2":genre_count}
    fav_genre_map = {'user':{'g1':2,'g2':2,'g3':4},'user2':{'g1':2,'g2':2,'g3':5}}
    """
    
    for a in user_songs.keys():
        user_songs[a] = set(user_songs[a])
    
    for a in song_genres.keys():
        song_genres[a] = set(song_genres[a])
    
    fav_genre_map = {}
    for u,s_list in user_songs.items():
        #i = set(s_list)
        fav_genre_map[u] = {}
        for genre_name,genre_s_list in song_genres.items():
            #j = set(genre_s_list)
            ij = s_list.intersection(genre_s_list)
            if ij:
                fav_genre_map[u][genre_name] = len(ij)
    print(fav_genre_map)
    
    final_out = {}
    for k,v in fav_genre_map.items():
        l = v.values()
        max_freq = max(l)
        final_out[k] = []
        for a,b in v.items():
            if b == max_freq:
                final_out[k].append(a)
    #print(final_out)
    
    return final_out

userSongs = {  
   "David": ["song1", "song2", "song3", "song4","song10","song12", "song8"],
   "Emma":  ["song5", "song6", "song7"]
}

songGenres = {  
   "Rock":    ["song1", "song3"],
   "Dubstep": ["song7"],
   "Techno":  ["song2", "song4","song10","song12"],
   "Pop":     ["song5", "song6"],
   "Jazz":    ["song8", "song9"]
}

print(fav_genres(userSongs,songGenres))
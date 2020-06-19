"""
// Time Complexity : O(M * N) #M -> userSongs, N -> songGenres
// Space Complexity : O(max(M,N)) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
"""
def fav_genres(user_songs,song_genres):
    """
    desired stucture - {"genre1":genre_count,"genre2":genre_count}
    fav_genre_map = {'user':{'s1':2,'s2':2,'s3':4},'user2':{'s1':2,'s2':2,'s3':5}}
    """
    
    for a in user_songs.keys():
        user_songs[a] = set(user_songs[a])
    
    for a in song_genres.keys():
        song_genres[a] = set(song_genres[a])
    
    fav_genre_map = {}
    for u,s_list in user_songs.items():
        #i = set(s_list)
        fav_genre_map[u] = {}
        for s_name,genre_s_list in song_genres.items():
            #j = set(genre_s_list)
            ij = s_list.intersection(genre_s_list)
            if ij:
                fav_genre_map[u][s_name] = len(ij)
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
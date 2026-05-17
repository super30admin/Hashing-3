# problem 2 



def favoritegenre(userMap, genreMap):
    # convert the song to genre map 
    song_genre_map = {}
    for genre,s_lists in genreMap.items():
        for s_list in s_lists:
            song_genre_map[s_list] = genre
    result = {}
    for user,s_lists in userMap.items():
        freq_map = {} # track the count 
        result[user] = []
        max_count = 0 
        for s_list in s_lists:
            genre =song_genre_map[s_list]
            freq_map[genre] = freq_map.get(genre,0)+1 
            curr_count = freq_map[genre]
            max_count = max(max_count,curr_count)
        print(freq_map)
        for s_name,count in freq_map.items():
            if count == max_count:
                result[user].append(s_name)
    return result


userSongs = {
    "David": ["song1", "song2", "song3", "song4", "song8"],
    "Emma": ["song5", "song6", "song7"]
}

songGenres = {
    "Rock": ["song1", "song3"],
    "Dubstep": ["song7"],
    "Techno": ["song2", "song4"],
    "Pop": ["song5", "song6"],
    "Jazz": ["song8", "song9"]
}

res = favoritegenre(userSongs, songGenres)
print(res)

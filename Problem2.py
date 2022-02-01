def fav_genre(user_map, genre_map):
    song_genre_map = {}
    for key, value in genre_map.items():
        for song in value:
            song_genre_map[song] = key
    ans = {}
    for key, value in user_map.items():
        temp = {}
        user_ans = []
        mx = 0
        for song in value:
            if song_genre_map[song] not in temp:
                temp[song_genre_map[song]] = 1
            else:
                temp[song_genre_map[song]] += 1 
            if temp[song_genre_map[song]] > mx:
                user_ans = [song_genre_map[song]]
                mx = temp[song_genre_map[song]]
            elif temp[song_genre_map[song]] == mx:
                user_ans.append(song_genre_map[song])
        ans[key] = user_ans
    return ans
        
        
        

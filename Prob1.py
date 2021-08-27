userSongs = { "David":["song1", "song2", "song3", "song4", "song8"], "Emma":["song5", "song6", "song7"]}

songGenres = { "Rock":["song1", "song3"], "Dubstep": ["song7"], "Techno":  ["song2", "song4"], "Pop":["song5", "song6"], "Jazz":["song8", "song9"]}

song_gen_map = {}
result_map = {}
genre_map = {}
for genre in songGenres:
    song_li = songGenres[genre]
    for s in song_li:
        song_gen_map[s] = genre

for user in userSongs:
    genre_map = {}
    song_li = userSongs[user]
    for s in song_li:
        genre_map[song_gen_map[s]] = genre_map.get(song_gen_map[s],0) + 1
    max_el = 0
    li =[]
    for k,v in genre_map.items():
        if v > max_el:
            max_el = v
            li = []
            li.append(k)
        elif v == max_el:
            li.append(k)
    result_map[user] = li

print result_map

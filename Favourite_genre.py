from collections import defaultdict
def favorite_genre(user_map, genre_map):
    res = {}
    song_to_genre = {}

    # create Song / genre map

    for genre, songs in genre_map.items():
        for song in songs:
            song_to_genre[song] = genre
    for user, songs in user_map.items():
        count = defaultdict(int)
        max_count = 0
        res[user] = []
     # Count genre frequency for each user


        for song in songs:
            genre = song_to_genre.get(song)
            if genre:
                count[genre] += 1
                max_count = max(max_count, count[genre])
        for genre, c in count.items():
            if c == max_count:
                res[user].append(genre)
    return res

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
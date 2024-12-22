# TC; O(U * S)

# find the favourite genre of the user
def favorite_genre(user_songs, song_genres):
    # create a mapping from song to song_genres
    hmap = {}
    for key in song_genres:
        lst = song_genres[key]
        for el in lst:
            hmap[el] = key
    print(hmap)
    hmap_ans = {}
    for user in user_songs:
        genre_count = {}
        max_fre = float("-inf")
        max_frq_gen = []
        songs = user_songs[user]
        for song in songs:
            if song in hmap:
                genre = hmap[song]
                genre_count[genre] = genre_count.get(genre, 0) + 1

        # Find the genres with the maximum frequency
        max_fre = max(genre_count.values(), default=0)
        max_frq_gen = [genre for genre, count in genre_count.items() if count == max_fre]

        # Store the result for the user
        hmap_ans[user] = max_frq_gen
    return hmap_ans

def main():
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

if __name__ == "__main__":
    main()

# Time Complexity : O(mn)
# Space Complexity :O(n)
# Passed on Leetcode: yes

from collections import defaultdict

def favorite_genre(user_songs, song_genres):
    # Create a song to genre mapping for quick lookup
    song_to_genre = {}
    for genre, songs in song_genres.items():
        for song in songs:
            song_to_genre[song] = genre
    
    # Create a dictionary to store user's favorite genres
    user_favorite_genres = defaultdict(list)
    
    # Iterate through each user and their songs
    for user, songs in user_songs.items():
        genre_count = defaultdict(int)
        max_count = 0
        
        for song in songs:
            if song in song_to_genre:
                genre = song_to_genre[song]
                genre_count[genre] += 1
                max_count = max(max_count, genre_count[genre])
        
        for genre, count in genre_count.items():
            if count == max_count:
                user_favorite_genres[user].append(genre)
    
    return dict(user_favorite_genres)

# Test the function with your example data
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

result = favorite_genre(user_songs, song_genres)
print(result)

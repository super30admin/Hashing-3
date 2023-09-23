# Time Complexity: O(songs)
# Space Complexity: O(users)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from collections import defaultdict

class Solution(object):
    def favoriteGenres(userSongs, songGenres):
        song_to_genre = {}
        for genre, songs in songGenres.items():
            for song in songs:
                song_to_genre[song] = genre
        user_favorites = defaultdict(list)
        for user, songs in userSongs.items():
            genre_counts = defaultdict(int)
            max_count = 0
            for song in songs:
                if song in song_to_genre:
                    genre = song_to_genre[song]
                    genre_counts[genre] += 1
                    max_count = max(max_count, genre_counts[genre])
            favorite_genres = [genre for genre, count in genre_counts.items() if count == max_count]
            user_favorites[user] = favorite_genres
        return dict(user_favorites)
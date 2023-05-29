# Time Compelxity : O(U * S), where U is the number of users and S is the total number of songs across all users
# Space Complexity : O(S + G), where S is the total number of songs and G is the number of unique genres. 
from typing import List, Dict

class Solution:
    def favoriteGenres(self, userSongs: Dict[str, List[str]], songGenres: Dict[str, List[str]]) -> Dict[str, List[str]]:
        song_to_genre = {}  # Map each song to its genre
        for genre, songs in songGenres.items():
            for song in songs:
                song_to_genre[song] = genre
        
        user_favorites = {}  # Map each user to their favorite genre(s)
        for user, songs in userSongs.items():
            genre_count = {}  # Count the number of songs per genre for the user
            max_count = 0  # Track the maximum count
            
            # Count the number of songs per genre for the user
            for song in songs:
                genre = song_to_genre.get(song)
                if genre:
                    genre_count[genre] = genre_count.get(genre, 0) + 1
                    max_count = max(max_count, genre_count[genre])
            
            # Add the genres with maximum count to the user's favorites
            favorites = [genre for genre, count in genre_count.items() if count == max_count]
            user_favorites[user] = favorites
        
        return user_favorites
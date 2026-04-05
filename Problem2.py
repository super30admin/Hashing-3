"""
1. We maintain a song to genre hashmap
2. now we can go through each user and check their favorite genre from the songs they have listened to.
3. While iterating through the songs of a user, we maintain a genre count hashmap and a max count variable.
4. Finally, we find the genre with the maximum count and add it to the result.

Time Complexity: O(M + N) where M is the number of songs in songGenres and N is the total number of songs
Space Complexity: O(M) to store the mapping of each song to its genre.
"""

from collections import defaultdict

def favoritegenre(userSongs, songGenres):

    # Create a mapping from song to its genre
    song_to_genre = {}
    for genre, songs in songGenres.items():
        for song in songs:
            song_to_genre[song] = genre
            
    res = {}
    
    # Process each user's songs
    for user, songs in userSongs.items():
        genre_count = defaultdict(int)
        max_count = 0
        
        for song in songs:
            # Check genre of the song
            if song in song_to_genre:
                genre = song_to_genre[song]
                genre_count[genre] += 1
                max_count = max(max_count, genre_count[genre])
                
        # Find all genres that share the maximum listening count
        if max_count == 0:
            res[user] = []
        else:
            res[user] = [g for g, count in genre_count.items() if count == max_count]
            
    return res


# testing the function
if __name__ == '__main__':
    userSongs = {  
       "David": ["song1", "song2", "song3", "song4", "song8"],
       "Emma":  ["song5", "song6", "song7"]
    }
    songGenres = {  
       "Rock":    ["song1", "song3"],
       "Dubstep": ["song7"],
       "Techno":  ["song2", "song4"],
       "Pop":     ["song5", "song6"],
       "Jazz":    ["song8", "song9"]
    }
    print(favoritegenre(userSongs, songGenres))
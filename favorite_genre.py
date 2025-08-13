# TimeComplexity:O(s+u)
# SpaceComplexity:O(s)
# Approach: to get songa nd gener in O(1) we make song and genere map




"""
Given a map Map<String, List> userSongs with user names as keys and a list of all the songs that the user has listened to as values.

Also given a map Map<String, List> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.

The task is to return a map Map<String, List>, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.

Example 1:

Input:

userSongs = {

"David": ["song1", "song2", "song3", "song4", "song8"],

"Emma": ["song5", "song6", "song7"]

},

songGenres = {

"Rock": ["song1", "song3"],

"Dubstep": ["song7"],

"Techno": ["song2", "song4"],

"Pop": ["song5", "song6"],

"Jazz": ["song8", "song9"]

}

Output: {

"David": ["Rock", "Techno"],

"Emma": ["Pop"]
def favorite_genre(user_map, genre_map):
    result = {}
    # TODO: implement logic here
    return result

if __name__ == "__main__":
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


}


"""
from collections import defaultdict
def favorite_genre(user_songs, song_genres):
    result = {}
    # TODO: implement logic here
    songtoGenre=dict()
    for genere in song_genres:
        for song in song_genres[genere]:
            
            songtoGenre[song]=genere
    for user in user_songs:
        freqMap=defaultdict(int)
        mx=0
        for song in user_songs[user]:
            freqMap[songtoGenre[song]]+=1
            mx=max(mx,freqMap[songtoGenre[song]])
        ans=list()
        for freq in freqMap:
            if freqMap[freq]==mx:
                ans.append(freq)
        result[user]=ans
        
        
            
            
    
    return result

if __name__ == "__main__":
    # Test Case 1: Original example
    user_songs1 = {
        "David": ["song1", "song2", "song3", "song4", "song8"],
        "Emma": ["song5", "song6", "song7"]
    }
    song_genres1 = {
        "Rock": ["song1", "song3"],
        "Dubstep": ["song7"],
        "Techno": ["song2", "song4"],
        "Pop": ["song5", "song6"],
        "Jazz": ["song8", "song9"]
    }
    # Expected output: {'David': ['Rock', 'Techno'], 'Emma': ['Pop']}
    print(favorite_genre(user_songs1, song_genres1))

    # Test Case 2: User has no songs
    user_songs2 = {
        "Alice": [],
        "Bob": ["song1"]
    }
    song_genres2 = {
        "Rock": ["song1"],
    }
    # Expected output: {'Alice': [], 'Bob': ['Rock']}
    print(favorite_genre(user_songs2, song_genres2))

   

class Solution:
    
    """
    Description: from given maps of user-songs and song-genre, find the favorate genre of each user in form of a map
    
    Time Complexity: O(n_songs * n_users) {considering genres are usually going to be less than both}
    Space Complexity: O(n_songs) + O(n_users * n_genres)
    where n_users, n_songs, and n_genres are number of users, songs and genres respectively
    
    Approach:
    1. convert songGenres dictionary to genre-song dictionary (avoid iterating each value)
    2. get a count of each song category for each user as a dictionary of a dictionary (count-genre)
    3. from userSongs dictionary and the count-genre, find maximum value (can have duplicates here)
    4. iterate in each count-genre for each user to get the genres mapped to maximum value found in #3
    """
    
    from collections import defaultdict
    
    def getFavGenres(userSongs, songGenres):
        
        output = {}

        genreSongs = defaultdict(int)
        for genre, song_list in songGenres.items():
            for song in song_list:
                genreSongs[song] = genre

        userGenres = defaultdict(dict)
        for user, song_list in userSongs.items():
            countGenre = defaultdict(int)
            for song in song_list:
                countGenre[genreSongs[song]] += 1
            userGenres[user] = countGenre

        for user in userSongs.keys():
            maxval = max(userGenres[user].values())
            result = []
            for k, v in userGenres[user].items():
                if v == maxval:
                    result.append(k)
            output[user] = result
            
        return output

s = Solution
userSongs = {"David": ["song1", "song2", "song3", "song4", "song8"],
             "Emma": ["song5", "song6", "song7"]}
songGenres = {"Rock": ["song1", "song3"],
              "Dubstep": ["song7"],
              "Techno": ["song2", "song4"],
              "Pop": ["song5", "song6"],
              "Jazz": ["song8", "song9"]}

print(s.getFavGenres(userSongs, songGenres))

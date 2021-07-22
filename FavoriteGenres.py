# TC: O(S + U*k) where S is the no. of songs, U is the number of user and k is the average no. of songs liked by a particular user. 
# SC: O(S + U) which will be the size of hashmap storing the genre for each song and U is the size of hashmap that stores the count of each genre by a particular user.

class Solution: 
    def favoriteGenres(self, userSongs:dict[str,list[str]], songGenres:dict[str,list[str]]) -> dict[str,list[str]]: 
        if not songGenres or len(songGenres) == 0: 
            return []
        
        genresOfSong = {}
        result = {}
        
#         populate the songs and its respective genre in the new hashtable
        for genre,songs in songGenres.items(): 
            for song in songs: 
                genresOfSong[song] = genre
        
        for user, songs in userSongs.items(): 
            userGenre = {}
            user_max = 0
            for song in songs: 
                genre = genresOfSong.get(song)
                userGenre[genre] = userGenre.get(genre, 0) + 1
                if userGenre.get(genre) > user_max: 
                    user_max = max(user_max, userGenre.get(genre))
            
            for k,v in userGenre.items(): 
                if user_max > 1 and v == user_max: 
                    if user in result.keys():
                        genres = result.get(user)
                        genres.append(k)
                        result[user] = genres
                    else: 
                        result[user] = [k]
        return result
    
if __name__ == "__main__": 
    # userSongs = {"David": ["song1", "song2", "song3", "song4", "song8"], "Emma":  ["song5", "song6", "song7"]}
    # songGenres = {"Rock": ["song1", "song3"], "Dubstep": ["song7"], "Techno":  ["song2", "song4"],"Pop":     ["song5", "song6"], "Jazz":    ["song8", "song9"]}
    
    userSongs = { "David": ["song1", "song2"], "Emma":  ["song3", "song4"]}
    songGenres = {}
    
    solutionObj = Solution()
    print(solutionObj.favoriteGenres(userSongs, songGenres))

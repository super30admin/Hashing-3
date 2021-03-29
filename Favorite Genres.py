class Solution:
    def favoriteGenres(self, userSongs, genreSongs):
        #Approach: HashMap
        #Time Complexity: O(m * n)
        #Space Complexity: O(m + n)
        #where, m and n are the number of songs and number of users, respectively
        
        songGenre = {}
        for genre in genreSongs:
            for song in genreSongs[genre]:
                songGenre[song] = genre
                
        result = {}
        for user in userSongs:
            freqMap = {}
            mostFreq = 0
            for song in userSongs[user]:
                genre = songGenre[song]
                freqMap[genre] = freqMap.get(genre, 0) + 1
                mostFreq = max(mostFreq, freqMap[genre])
                
            freqGenres = []
            for genre in freqMap:
                if freqMap[genre] == mostFreq:
                    freqGenres.append(genre)
            
            result[user] = freqGenres
        
        return result

#Driver code
userSongs = {
    "David": ["song1", "song2", "song3", "song4", "song8"],
    "Emma": ["song5", "song6", "song7"]
}

genreSongs = {
    "Rock": ["song1", "song3"],
    "Dubstep": ["song7"],
    "Techno": ["song2", "song4"],
    "Pop": ["song5", "song6"],
    "Jazz": ["song8", "song9"]
}

sol = Solution()
print(sol.favoriteGenres(userSongs, genreSongs))
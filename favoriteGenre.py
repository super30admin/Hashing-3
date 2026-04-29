class favGenre:
    def __init__(self, userMap, genreMap):
        self.result = dict()
        self.songGenreMap = dict()
        
        for genre, songs in genreMap.items(): # O(N)
            for song in songs:
                self.songGenreMap[song] = genre
        
        for user, songs in userMap.items(): #O(m*l)
            genreCount = dict()
            self.result[user] = []
            maxCount = 0
            for song in songs:
                genre = self.songGenreMap[song]
                if genre not in genreCount:
                    genreCount[genre] = 0
                genreCount[genre]+=1
                maxCount = max(maxCount, genreCount[genre])
            
            for genre, count in genreCount.items():
                if count == maxCount:
                    self.result[user].append(genre)

userMap = {
    "Alice": ["song1", "song2", "song3", "song4"],
    "Bob": ["song5", "song6"]
}

genreMap = {
    "Rock": ["song1", "song3"],
    "Pop": ["song2", "song4"],
    "Jazz": ["song5", "song6"]
}
obj = favGenre(userMap, genreMap)
print(obj.result)
                
            
        
        
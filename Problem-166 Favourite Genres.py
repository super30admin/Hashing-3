# Favourite Genres
# https://github.com/adhish70/Hashing-3

# Time Complexity: O(no. of songs)
# Space Complexity: O(no. of songs)

class Solution:
    def favGenre(self, userSongs, genreSongs):
        result = dict()

        # Make a song to genre hashmap
        songGenre = dict()
        for genre in genreSongs:
            songList = genreSongs[genre]

            for song in songList:
                songGenre[song] = genre
        
        # For each user, conver the song list into a genre count hashmap
        for user in userSongs.keys():
            songList = userSongs[user]
            genreCount = dict()
            maxFreq = 0

            # Count hashmap
            for song in songList:
                if songGenre[song] in genreCount:
                    genreCount[songGenre[song]] += 1
                else:
                    genreCount[songGenre[song]] = 1

                maxFreq = max(maxFreq, genreCount[songGenre[song]])

            # Add user to result
            result[user] = []

            # Add to result the max count genre
            for g in genreCount:
                if genreCount[g] == maxFreq:
                    result[user].append(g)

        return result

#Time: O(Users*Songs)
#Spce: O(Songs)


class FavoriteGenre:

    def __init__(self):
        pass

    def getGenreFrequencyMap(self, songs, songGenreMap):

        
        frequencyMap = {}
        if (songs == None):
            return frequencyMap

        
        for song in songs:
            genre = songGenreMap[song]
            if (genre in frequencyMap):
                frequencyMap[genre] += 1
            else:
                frequencyMap[genre] = 1

        return frequencyMap

    def getMostHeardGenres(self, genreFrequencyMap):

        
        mostHeardGenres = []

        if (genreFrequencyMap == None):
            return mostHeardGenres
        maxFrequency = float('-inf')

       
        for genre in genreFrequencyMap:
            frequency = genreFrequencyMap[genre]

            if (maxFrequency < frequency):
                mostHeardGenres = [genre]
                maxFrequency = frequency

            elif (maxFrequency == frequency):
                mostHeardGenres.append(genre)

        return mostHeardGenres

    def favoriteGenres(self, userSongsListMap, genreSongsMap):

       
        songGenreMap = {}

        for genre in genreSongsMap:
            songs = genreSongsMap[genre]

            if (songs == None or len(songs) == 0):
                continue

            for song in songs:
                songGenreMap[song] = genre

        userTopGenresMap = {}

        
        for user in userSongsListMap:
            songs = userSongsListMap[user]

            if (songs == None or len(songs) == 0):
                continue

           
            genreFrequencyMap = self.getGenreFrequencyMap(songs, songGenreMap)
            mostHeardGenres = self.getMostHeardGenres(genreFrequencyMap)

            userTopGenresMap[user] = mostHeardGenres

        return userTopGenresMap


if __name__ == '__main__':

    #   example 
    userSongsListMap = {}
    genreSongsMap = {}

    userSongsListMap['Fred'] = ['song1', 'song2', 'song3']
    userSongsListMap['Jenie'] = ['song4', 'song5']
    userSongsListMap['Rob'] = ['song6']

    genreSongsMap['Rock'] = ['song1', 'song3']
    genreSongsMap['Pop'] = ['song4']
    genreSongsMap['Jazz'] = ['song2', 'song5', 'song6']

    fg = FavoriteGenre()
    userTopGenresMap = fg.favoriteGenres(userSongsListMap, genreSongsMap)
    print(userTopGenresMap) 

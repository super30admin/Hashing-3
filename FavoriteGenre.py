'''
Solution:
1.  First, create a song-genre HashMap
2.  Now, for each user, create genre-count HashMap, and most heard genres with the already existing information, i.e.
    user-songs' list Map and genre-songs Map.
3.  So, for each user, directly append most heard songs respectively.

Time Complexity:  O(U * S) ... as described in the favoriteGenres() method.
Space Complexity:   O(S) for song-genre Map + O(G) for genre-count Map approx. ~ O(S + S) ~ O(S) [...this is extra space...]
'''


class FavoriteGenre:

    def __init__(self):
        pass

    def __getGenreFrequencyMap(self, songs, songGenreMap):

        #   Time Complexity:    O(S) --> S is number of songs
        #   initializations and edge case checks
        frequencyMap = {}
        if (songs == None):
            return frequencyMap

        #   for each song, and song-genre HashMap -> extract the frequencies associated with each genre
        for song in songs:
            genre = songGenreMap[song]
            if (genre in frequencyMap):
                frequencyMap[genre] += 1
            else:
                frequencyMap[genre] = 1

        return frequencyMap

    def __getMostHeardGenres(self, genreFrequencyMap):

        #   Time Complexity:    O(G) -- G is the number of Genres
        #   initilaizations and edge case checks
        mostHeardGenres = []

        if (genreFrequencyMap == None):
            return mostHeardGenres
        maxFrequency = float('-inf')

        #   for each genre in genre-count HashMap, collect all top frequency genres
        for genre in genreFrequencyMap:
            frequency = genreFrequencyMap[genre]

            if (maxFrequency < frequency):
                mostHeardGenres = [genre]
                maxFrequency = frequency

            elif (maxFrequency == frequency):
                mostHeardGenres.append(genre)

        return mostHeardGenres

    def favoriteGenres(self, userSongsListMap, genreSongsMap):

        #   create a song-genre HashMap in O(S) time where S is total number of songs as a song belongs to only one genre
        songGenreMap = {}

        for genre in genreSongsMap:
            songs = genreSongsMap[genre]

            if (songs == None or len(songs) == 0):
                continue

            for song in songs:
                songGenreMap[song] = genre

        userTopGenresMap = {}

        #   for each user, get genre-count Map and most heard genres => O(U * (S + G)) ~ O(U * S)
        #   where U => Users, S => Songs, G => Genres
        for user in userSongsListMap:
            songs = userSongsListMap[user]

            if (songs == None or len(songs) == 0):
                continue

            #   O(G) + O(S) ~ O(S)
            genreFrequencyMap = self.__getGenreFrequencyMap(songs, songGenreMap)
            mostHeardGenres = self.__getMostHeardGenres(genreFrequencyMap)

            userTopGenresMap[user] = mostHeardGenres

        return userTopGenresMap


if __name__ == '__main__':

    #   example initializations and call the main method
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
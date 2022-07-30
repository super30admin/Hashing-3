'''
Number of songs: m
Number of genre: k
Number of users: n

Time Complexity: 0(n*m)+k
Space Complexity: 0(m)
'''

class FavoriteGenre:
    def __init__(self):
        self.resultDict = {}
        self.songsGenreDict = {}
    
    def favouriteSongs(self,userSongsListMap,genreSongsMap):
        
        # create a songs-genre dictionary
        for key in genreSongsMap:
            songsList = genreSongsMap[key]
            for song in songsList:
                self.songsGenreDict[song] = key
        '''created songs list'''
        
        # print('1. genreSongsMap is:\t',self.songsGenreDict)
        
        # iterate userSongsListMap
        for users in userSongsListMap:
            songsList = userSongsListMap[users]
            maxCount = 0
            usersMap = {}
            for song in songsList:
                if self.songsGenreDict[song] not in usersMap:
                    usersMap[self.songsGenreDict[song]] = 1
                else:
                    usersMap[self.songsGenreDict[song]] += 1
                
                maxCount = max(maxCount,usersMap[self.songsGenreDict[song]])
            '''end of user iteration'''
            
            # print('\n')
            # print('2.1. Users map is:\t',usersMap)
            
            # add to the resultList
            resultList = []
            for genre in usersMap:
                if usersMap[genre] == maxCount:
                    resultList.append(genre)
            '''end of usersMap iteration'''
            
            self.resultDict[users] = resultList
            # print('2.2. ResultDict is:\t',self.resultDict)
        '''end of for loop'''
        
        # print('Result Dict is:\t',self.resultDict)
        
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
    fg.favouriteSongs(userSongsListMap,genreSongsMap)
    
    print(fg.resultDict)
#Time complexity --> o(U(S+G)) where U --> no of users,S --> no of songs per user,G--> genre frequency .
#space complexity --> o(S+U(S+G)) where U --> no of users,S --> no of songs per user,G--> genre frequency .
class FavouriteGenre:
    def __init__(self,usersongs,songgenres):
        self.usersongs=usersongs

        self.songgenres=songgenres
        
    def name_genre(self):
        songsgenres = dict()
        # converting genre song dict to song genre dict
        for key,value in self.songgenres.items():
            for val in value:
                if val not in self.songgenres:
                    songsgenres[val]=[key]
                else:
                    songsgenres[val].append(key)
        usergenremap=dict()
        #creating a map for the users as the key and the their favourite genres as the value
        for name,song in self.usersongs.items():
        #to generate the genre frequency for every user
            genrefreq=self.getgenrefreqmap(song,songsgenres)
        #to generate the mostly heard songs genre from the above created genre frequency list
            mostheard=self.getmostheardgenre(genrefreq)
         #store the user as the key and favourite genre as the value.
            usergenremap[name]=mostheard
        return usergenremap
    #calculating the genre frequency for each of the given users songs list
    def getgenrefreqmap(self,song,songgenres):
        freqmap=dict()
        for songs in song:
            for genre in songgenres[songs]:
                if  genre not in freqmap:
                    freqmap[genre]=1
                else:
                    freqmap[genre]=freqmap[genre]+1
        return freqmap
    #only keeping the most heard genre from the given list.for instance if rock-2,pop-2,HM-1 then we have to populate both rock and pop to that specific user.
    def getmostheardgenre(self,genrefreq):
        mini=float('-inf')
        genrelist=[]
        for key,value in genrefreq.items():
            count = value
            if value>mini:
                genrelist = []
                mini=value
                genrelist.append(key)
            elif count==mini:
                genrelist.append(key)
        return genrelist


if __name__=="__main__":
    userSongs = {"David": ["song1", "song2", "song3", "song4", "song8"],"Emma": ["song5", "song6", "song7"]}
    songGenres = {"Rock": ["song1", "song3"],"Dubstep": ["song7"],"Techno": ["song2", "song4"],"Pop": ["song5", "song6"],"Jazz": ["song8", "song9"]}
    genre=FavouriteGenre(userSongs,songGenres)
    print(genre.name_genre())


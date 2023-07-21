#Time Complexity:O(m(users)*l(songs))
#Space Complexity:O(l+m)

class Solution():
    def __init__(self):
        self.songs={}
    def genreFind(self,genre,song):
        for type in genre:
            if song in genre.get(type):
                return type
        
    def genereCount(self,genre,song):
        result=[]
        for s in song:
            if s in self.songs:
                result.append(self.songs.get(s))
            else:
                self.songs[s] = self.genreFind(genre,s)
                result.append(self.songs.get(s))
        freq={}
        for ele in result:
            freq[ele]=freq.get(ele,0)+1
        x=[]
        maxi=0
        for ele in freq:
            maxi=max(maxi,freq.get(ele))
        for ele in freq:
            if freq.get(ele)==maxi:
                x.append(ele)
        return x
        
    def favouriteGenre(self,user,genre):
        result = {x: self.genereCount(genre, user.get(x)) for x in user}
        return result
        
user={
    "David": ["song1", "song2", "song3", "song4", "song8"],
    "Emma": ["song5", "song6", "song7"]}
genre={
    "Rock": ["song1", "song3"],

    "Dubstep": ["song7"],

    "Techno": ["song2", "song4"],

    "Pop": ["song5", "song6"],

    "Jazz": ["song8", "song9"]}

print(Solution().favouriteGenre(user,genre))
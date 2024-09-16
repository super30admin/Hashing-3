'''
Time complexity: O(N) where N is length of string
space complexity:  O(N)

- traverse the string and keep  storing substrings of length 10 in a hashmap
- if the substring already exists in the hashmap, add it to the result hashmap
- convert the resulting hashmap into a list and return
'''
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        substrings=set()
        result=set()
        
        for i in range(0, len(s)-1):
            substr=s[i:i+10]
            
            if substr in substrings:
                result.add(substr)
            else:
                substrings.add(substr)
                
        return(list(result))


'''
Time complexity: 
space complexity:Number  of  songs+ number of users

- create a song-> genre map for searching the genre of song easily
- traverse the songs for all users and for each song, keep the track of number of songs from a particular genre in the user's playlist
- keep track of genre listened maximum times, and at the end, add all the genre with that frequency

'''

class Solution:
    def fav_genre(self, users: dict, genre: dict) -> dict:
        result={user:[] for user in users}
        songs={}

        

        #creating a dict with song as key and genre as value for easy search
        for i in genre:
            for j in genre[i]:
                songs[j]=i
        
        #traversig the users dictionary to find favorite genre
        for user in users:
            user_genre={}
            favorite=None

            #traversing all songs for a user and finding the genre user listened to most
            for song in users[user]:
                song_genre= songs[song]

                if song_genre in user_genre:
                    user_genre[song_genre]+=1
                else:
                     user_genre[song_genre]=1
            
                if favorite==None:
                    favorite=song_genre
                else:
                    if user_genre[song_genre] > user_genre[favorite]:
                        favorite=song_genre
            
            #getting genres with same frequency as genre listened max times
            for i in user_genre:
                if user_genre[i]==user_genre[favorite]:
                    result[user].append(i)
        return result

users = {  

   "David": ["song1", "song2", "song3", "song4", "song8"],

   "Emma":  ["song5", "song6", "song7"]

}

genre = {  

   "Rock":    ["song1", "song3"],

   "Dubstep": ["song7"],

   "Techno":  ["song2", "song4"],

   "Pop":     ["song5", "song6"],

   "Jazz":    ["song8", "song9"]

}


obj=Solution()
print(obj.fav_genre(users, genre))


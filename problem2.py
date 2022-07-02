
#Favourite Genres

# // Time Complexity : O(N*K) n = users, k=users's list of songs
# // Space Complexity :O(S) s=songs
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

def favoriteGenres(userSongs, songGenres):
    songs={}
    for i in songGenres:
        for j in songGenres[i]:
            songs[j]=i                              #first make a dict with all the songs and their value as the genre
    favorite={}
    for i in userSongs:
        temp={}
        maxi=0
        for j in userSongs[i]:                  #for every songs in a person's list, find their genre and store the frequency of it
            if songs[j] in temp:            
                temp[songs[j]]+=1
                
            else:
                temp[songs[j]]=1
            maxi=max(maxi,temp[songs[j]])       #store the max frequency of a genre for a person
        for t in temp:                  
            if temp[t]==maxi:
                if i in favorite:
                    favorite[i].append(t)       #add the genre with the highest frequency to the value of the persons dict
                else:
                    favorite[i] = [t]
                    
    return favorite

userSongs = {"David": ["song1", "song2", "song3", "song4", "song8"],

"Emma": ["song5", "song6", "song7","song1", "song3"]}

songGenres = {"Rock": ["song1", "song3"],

"Dubstep": ["song7"],

"Techno": ["song2", "song4"],

"Pop": ["song5", "song6"],

"Jazz": ["song8", "song9"]}
print(favoriteGenres(userSongs, songGenres))
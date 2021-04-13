#Time Complexity:O(n)
#Space Complexity:O(n)
#Approach:parse through the songGenres and identify the genre of each song. For each user in userMap,obtain the song and its genre and get the
#count of songs of each genre.Based on count, obtain the maxvalue. Use the data so far collected to map each user to the maxValued genre.
userSongs = {

"David": ["song1", "song2", "song3", "song4", "song8"],

"Emma": ["song5", "song6", "song7"]

}

songGenres = {

"Rock": ["song1", "song3"],

"Dubstep": ["song7"],

"Techno": ["song2", "song4"],

"Pop": ["song5", "song6"],

"Jazz": ["song8", "song9"]

}

def songGenreMap(userMap:dict,genreMap:dict):
    result={}
    songsToGenre={}
    for genre in genreMap:
        songs=genreMap[genre]
        if songs:
            for song in songs:
                songsToGenre[song]=genre
    maxVal=-1
    for user in userMap:
        count={}
        songs=userMap[user]
        result[user]=[]
        if songs:
            for song in songs:
                genre=songsToGenre[song]
                if genre not in count:
                    count[genre]=0
                count[genre]+=1
                maxVal=max(maxVal,count[genre])
        for genre in count:
            if count[genre]==maxVal:
                result[user].append(genre)
    print(result)
    
songGenreMap(userSongs,songGenres)
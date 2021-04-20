#Time Complexity :o(max(n.m , k.n )) n- songs ,m-genres , k-users
#Space Complexity :o(max(n,m))
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

userMap = {
   "David": ["song1", "song2", "song3", "song4", "song8","song10"],
   "Emma":  ["song5", "song6", "song7"]
}

genreMap = {
   "Rock":    ["song1", "song3"],
   "Dubstep": ["song7"],
   "Techno":  ["song2", "song4","song10"],
   "Pop":     ["song5", "song6"],
   "Jazz":    ["song8", "song9"]
}

songMap={}

for genre in genreMap:
    songList=genreMap[genre]
    for song in songList:
        songMap[song]=genre
        
res={}

for user in userMap:
    maxi=0
    songList=userMap[user]
    cntMap={}
    for song in songList:
        if(songMap[song] not in cntMap):
            cntMap[songMap[song]]=1
        else:
            cntMap[songMap[song]]+=1
        maxi=max(maxi,cntMap[songMap[song]])
    res[user]=[]
    for cnt in cntMap:
        if(cntMap[cnt]==maxi):
            res[user].append(cnt)

print(res)
            
            
        
        
    
    
    
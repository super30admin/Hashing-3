# // Time Complexity :O(max of songs present in genre list or song list) 
# // Space Complexity :O(n) 
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

def op(songs,songgenres):
    songtogenre={}
    
    for i in songgenres.keys():
        li=songgenres[i]
        for song in li:
            if song not in  songtogenre.keys():
                songtogenre[song]=[]
            songtogenre[song].append(i)
    print(songtogenre)
    result={}
    for i in songs:
        result[i]=[]
        maxcount=0
        li=songs[i]
        countmap={}
        for j in li:
            print(j)
            if songtogenre[j][0] not in countmap.keys():
                countmap[songtogenre[j][0]]=1
            countmap[songtogenre[j][0]]+=1
            maxcount=max(maxcount,countmap[songtogenre[j][0]])
        for genre in countmap:
            if countmap[genre]==maxcount:
                result[i].append(genre)
        
            
    return result

    
    
us={"David":["song1","song2","song3","song4","song8"],"Emma":["song5","song6","song7"]}
sg={"Rock":["song1","song3"],"Dubstep":["song7"],"Techno":["song2","song4"],"Pop":["song5","song6"],"Jazz":["song8","song9"]}
print(op(us,sg))
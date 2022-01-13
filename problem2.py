#Time , space O(n)

userSongs = {  
       "David": ["song1", "song2", "song3", "song4", "song8"],
       "Emma":  ["song5", "song6", "song7"]
    }
songGenres = {  
   "Rock":    ["song1", "song3"],
   "Dubstep": ["song7"],
   "Techno":  ["song2", "song4"],
   "Pop":     ["song5", "song6"],
   "Jazz":    ["song8", "song9"]
}

o={}

for u in userSongs:
    #song list
    sl=userSongs[u]
    h1={}
    #for songs in list
    for s in sl:
        #count of genre 
        for g in songGenres:
            if s in songGenres[g]:
                h1[g]=h1.get(g,0)+1
    print(h1.items())
    #user with max count of genre
    o[u] = [k for k,v in h1.items() if v == max(h1.values())]
 
print(o)
    

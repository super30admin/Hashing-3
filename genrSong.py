'''
time complexity: O(users * songs)
spcace complexity : O(1)
'''
class Solution:
    def findgenres(self,userSongs,songGenres):
        songtogenre = {}
        for g in songGenres:
            songs = songGenres[g]
            for s in songs:
                songtogenre[s] = g
        countGenr = {}
        res = {}
        for user in userSongs:
            maxs = -1
            countGenr = {}
            songs = userSongs[user]
            for s in songs:
                if songtogenre[s] not in countGenr:
                    countGenr[songtogenre[s]] = 0
                countGenr[songtogenre[s]]+=1
                maxs = max(countGenr[songtogenre[s]],maxs)
            for gen in countGenr:
                if(countGenr[gen] == maxs):
                    if user not in res:
                        res[user] = []
                    res[user].append(gen)
        return res
        

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

s = Solution()
print(s.findgenres(userSongs,songGenres)) 

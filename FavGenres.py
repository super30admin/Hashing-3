# HashMap
# TC: O(users * songs)
# SC: O(1)

class Solution:
    def findgenres(self,userSongs,songGenres):
        songtogenre = {}
        for g in songGenres:
            songs = songGenres[g]
            for s in songs:
                songtogenre[s] = g
        
        res = {}
        for user in userSongs:
            maxs = -1
            countGenre = {}
            songs = userSongs[user]
            for s in songs:
                if songtogenre[s] not in countGenre:
                    countGenre[songtogenre[s]] = 0
                countGenre[songtogenre[s]] += 1
                maxs = max(maxs, countGenre[songtogenre[s]])
            for gen in countGenre:
                if countGenre[gen] == maxs:
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



Obj = Solution()

print(Obj.findgenres(userSongs,songGenres))




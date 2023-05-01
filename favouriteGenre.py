import collections
class Solution:

    #Here we create a song-genre map, then we iterate through songs of each user and map them to genre. From this mapping we pick the max count of genre user listens to.
    #time complexity - O(n*k) + O(m*n) where m-users, n-songs, k-genre. Here all songs may be in all genre and all users may listen to all songs
    #space complexity - O(n) + O(k) -> n for songs-genre map and k for genre map for each user
    def favouriteGenre(self, userMap, genreMap):
        songMap = {}
        
        #create song-genre map
        for genre in genreMap:
            songs = genreMap[genre]
            for s in songs:
                songMap[s] = genre
                
        res = {}
        for user in userMap:
            genre = {}
            cnt = 0
            songs = userMap[user]
            for s in songs:
                g = songMap[s]
                if g not in genre:
                    genre[g] = [s]
                else:
                    genre[g].append(s)
                cnt = max(cnt, len(genre[g]))
            for g in genre:
                if len(genre[g])==cnt:
                    if user in res:
                        res[user].append(g)
                    else:
                        res[user] = [g]
        return res
                
                    
                
       
            
                  
s = Solution()
userMap = {"john":['s1','s2','s6'], "emma":['s3','s7'], "david":['s5','s7','s8']}
genreMap = {"pop":['s1', 's2', 's4'], "rock":['s3', 's5'], "classical": ['s6', 's7', 's8']}
result = s.favouriteGenre(userMap, genreMap)
print(result)
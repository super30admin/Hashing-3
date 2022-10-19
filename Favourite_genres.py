# Time complexity : O(m*n) --> number of users * number of songs
# Space complexity : O(songs)
# Leetcode : Solved

class Solution:
    def findFavourite(self, userSongs, songGenre):
        # Maintain a hashmap for the mapping of song to genre which is generated from the songGenre
        songToGenre = {}
        
        # result to store the mapping of user to favourite genre
        res = {}
        
        # traverse over all the genres in the songGenre and create an entry in the new hashmap if not present
        for key in songGenre:
            lis = songGenre[key]
            for song in lis:
                if song not in songToGenre:
                    songToGenre[song] = key
        
        # traverse over each user in the userSongs
        for user in userSongs:
            # create an empty list for each user in the res
            if key not in res:
                res[user] = []
                
            # we'll create a count map for each genre that user likes
            count = {}
            max_val = -math.inf
            
            # create a count map and keep track of the max freq
            for songs in userSongs[user]:
                if songToGenre[songs] not in count:
                    count[songToGenre[songs]] = 1
                count[songToGenre[songs]] += 1
                max_val = max(max_val, count[songToGenre[songs]])
            
            # traverse over the count map, and search for max freq, add all of them to the list of user in res
            for val in count:
                if count[val] == max_val:
                    res[user].append(val)
                    
        return res
    

#obj = Solution()
#userSongs = {
#"David": ["song1", "song2", "song3", "song4", "song8"],
#"Emma": ["song5", "song6", "song7"]
#}

#songGenre = {
#"Rock": ["song1", "song3"],
#"Dubstep": ["song7"],
#"Techno": ["song2", "song4"],
#"Pop": ["song5", "song6"],
#"Jazz": ["song8", "song9"]
#}
#print(obj.findFavourite(userSongs, songGenre))

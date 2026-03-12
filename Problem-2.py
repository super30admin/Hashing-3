# Time Complexity : O(U*S + G*S)
# Space Complexity : O(S)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# First map each song to its genre.
# Then for each user count occurrences of genres.
# Track the maximum count and store genres with that count.

def favoritegenre(userMap, genreMap):
    
    song_to_genre = {}
    
    for genre in genreMap:
        for song in genreMap[genre]:
            song_to_genre[song] = genre
    
    res = {}
    
    for user in userMap:
        count = {}
        max_count = 0
        
        for song in userMap[user]:
            genre = song_to_genre.get(song)
            
            if genre not in count:
                count[genre] = 0
            
            count[genre] += 1
            max_count = max(max_count, count[genre])
        
        res[user] = []
        
        for g in count:
            if count[g] == max_count:
                res[user].append(g)
    
    return res
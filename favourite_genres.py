class Solution:
    
    ## T.C = O(m.n)
    ## S.C = O(n)
    
    from collections import defaultdict
    
    def op(user_songs, song_genres):
        hm_song_genre = {}
        for key, values in song_genres.items():
            for val in values:
                hm_song_genre[val] = key
        
        hm_answer = defaultdict(list)
        for user, songs in user_songs.items():
            freq = defaultdict(int)
            mx = 0
            for song in songs:
                freq[hm_song_genre[song]] += 1
                mx = max(mx, freq[hm_song_genre[song]])
                
            for genre, k in freq.items():
                if k == mx:
                    hm_answer[user].append(genre)
    
        return hm_answer
            

user_songs = {
"David": ["song1", "song2", "song3", "song4", "song8"],
"Emma": ["song5", "song6", "song7"]
}

song_genres = {
"Rock": ["song1", "song3"],
"Dubstep": ["song7"],
"Techno": ["song2", "song4"],
"Pop": ["song5", "song6"],
"Jazz": ["song8", "song9"]
}

result = Solution.op(user_songs, song_genres)
print(result)

Output = {
"David": ["Rock", "Techno"],
"Emma": ["Pop"]
}
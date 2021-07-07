'''
Amazon | OA 2019 | Favorite Genres
'''


def favoGenre(userMap, genreMap):
    '''
    Time:
        O(N*M) where:
                N = max(users, songs, genres)
                M = second max(users, songs, genres)

    Space:
        O(N) where N = number of songs
        assuming songs are more numerous than users
    '''
    
    if not userMap or not genreMap:
        d = {}
        for u in userMap:
            d[u] = []
        return d
    
    # reverse the genre map:
    s_g = {}
    for gen in genreMap:
        for song in genreMap[gen]:
            s_g[song] = gen
    # GOAL --> s_g = { song123 : Rock }

    from collections import defaultdict
    u_gens = defaultdict(list)
    for u in userMap:
        for s in userMap[u]:
            gen = s_g[s]
            u_gens[u].append(gen)
    # GOAL --> u_gens = {david : [rock, rock, jazz, jazz, pop]}

    final = {}
    for u in u_gens:
        fav_gens = []
        temp = {}
        for s in u_gens[u]:
            if s in temp:
                temp[s] += 1
            else:
                temp[s] = 1
        maxVal = max(temp.values())
        for k in temp:
            if temp[k] == maxVal:
                fav_gens.append(k)
        final[u] = fav_gens
    return final
    # GOAL --> final = {david : {[rock, jazz]}

# TEST 1 #
# userMap, genreMap = {"David": ["song1", "song2", "song3", "song4", "song8"], "Emma": ["song5", "song6", "song7"]}, {"Rock":["song1", "song3"], "Dubstep": ["song7"], "Techno":  ["song2", "song4"], "Pop": ["song5", "song6"], "Jazz": ["song8", "song9"]}

# Output: {  
#    "David": ["Rock", "Techno"],
#    "Emma":  ["Pop"]
# }


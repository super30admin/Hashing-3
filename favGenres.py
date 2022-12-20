#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

def favGenres(userSongs, songGenres):
    output={}
    for i in userSongs:
        list=userSongs[i]
        count=collections.defaultdict(int)
        for j in list:
            for k,v in songGenres.items():
                if j in v:
                    count[k]+=1

        output[i]=[key for key,val in count.items() if val ==max(count.values())]
                
    
    return output
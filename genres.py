# Time: O(m,n)
# Space: O(1)
# Did it run on Leetcode: yes

def songs(self, genremap, usermap):
    res={}
    songtogenre={}
    for genre in genremap:
        songs=genremap[genre]
        for song in songs:
            songtogenre[song]=genre
    count={}
    for user in usermap:
        count={genre: 0 for genre in genremap}
        maxval=0
        res[user]=[]
        songs=usermap[user]
        for song in songs:
            genre=songtogenre[song]
            count[genre]+=1
            maxval=max(maxval,count[genre])
        for genre in count:
            if(count[genre]==maxval):
                res[user].append(genre)
    return res
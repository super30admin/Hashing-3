## Time - O(k*m*n)
## Space - O(m*n )

from collections import defaultdict
userSongs={'david':['s1','s3','s2','s8','s4'], 'emma':['s5','s6','s7']}
songGenre={'rock':['s1','s3'],'dubstep':['s7'],'techno':['s2','s4'],'pop':['s5','s6'],'jazz':['s8','s9']}
## m genres,, each has on an avg n songs
dic={}
for i in songGenre:
  for x in songGenre[i]:## O(mn)-time
    dic[x]=i## space-O(m*n) space
print(dic)
udic=defaultdict(list)
for i in userSongs: ### O(k*m*n) - k users
  genre=defaultdict(int) ##O(m)
  for song in userSongs[i]:
    genre[dic[song]]+=1
  maxx=max(genre.values())
  for key in genre:
    if genre[key]==maxx:
      udic[i].append(key)
print(udic)
def favoritegenre(usermap,genremap):
    
    songtogenre = {}
    for genre in genremap:
        if genremap[genre]:
            for song in genremap[genre]:
                songtogenre[song] = genre    
    #print(songtogenre)
    result = {}
    for user in usermap:
        if usermap[user]:
            result[user] = []
            freqmap = {}
            maxcount = 0
            for song in usermap[user]:
                if songtogenre[song] in freqmap:
                    freqmap[songtogenre[song]] +=1
                else:
                    freqmap[songtogenre[song]] = 0
                if maxcount < freqmap[songtogenre[song]]:
                    maxcount = freqmap[songtogenre[song]]
            for freq in freqmap:
                if freqmap[freq] == maxcount:
                    result[user].append(freq)
    return result

def main():

    usermap = {}
    genremap = {}
    usermap["David"] = ["song1", "song2", "song3", "song4", "song8"]
    usermap["Emma"] = ["song5", "song6", "song7"]
    genremap["Rock"] = ["song1", "song3"]
    genremap["Dubstep"] = ["song7"]
    genremap["Techno"] = ["song2", "song4"]
    genremap["Pop"] = ["song5", "song6"]
    genremap["Jazz"] = ["song8", "song9"]
    ans_map = favoritegenre(usermap,genremap)
    print(ans_map)

if __name__ == "__main__":
    main()

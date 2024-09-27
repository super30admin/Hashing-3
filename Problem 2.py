
class solution:

    def genere_finder(self,userSongs, songGeners):
        res = {}
        for user, u_songs in userSongs.items():
            count = {}
            for song in u_songs:
                for gen in songGeners:
                    if song in songGeners[gen]:
                        count[gen] = count.get(gen, 0) + 1
            res[user] = [key for key, val in count.items() if val == max(count.values())]
        return res

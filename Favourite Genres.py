#Time Complexity: O(U * S * G), where U is the number of users, S is the number of songs per user, and G is the number of genres.
#Space Complexity: O(S + G), where S is the number of songs per user and G is the number of genres.
def favGenres(userSongs, songGenres):
    output = {}
    for user in userSongs:
        song_list = userSongs[user]
        count = {}

        for song in song_list:
            for genre in songGenres:
                if(song in songGenres[genre]):
                    count[genre] = count.get(genre,0) + 1

        output[user] = [key for key, val in count.items() if val == max(count.values())]
    
    return output
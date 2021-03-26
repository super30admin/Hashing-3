# Created by Aashish Adhikari at 8:18 PM 3/25/2021

'''
Time Complexity:
O(U.S) where U = # of users, S = # of unique songs

Space Complexity:
O(S) + O(U.G)
'''

def favorite_genres(userSongs, songGenres):
    '''
    :param userSongs: Hashmap of users mapped to corresponding lists of songs.
    :param songGenres: Hashmap pf genres mapped to corresponding lists of songs
    :return: Hashmap where keys are usernames and values are the corresponding lists of favourite genres.
             Favourite genre is the one from which the user listens the maximum number of songs.
             A user can have multiple favourite genres.
    '''

    # Generate a hashmap of <song : genre>
    song_to_genre_hm = {} # SC : O(S)
    for genre in songGenres:  #   This nested for loop will run for a total of S iterations since each song will be encountered once.
        for song in songGenres[genre]:
            song_to_genre_hm[song] = genre

    sol = {}


    # For each user, find the favourite genre
    for user in userSongs:  # O(U)

        fav_genre_count_for_user = 0
        hm = {}
        for song in userSongs[user]:    # O(S)

            # find the genre of the song
            genre = song_to_genre_hm[song]

            if genre not in hm:
                hm[genre] = 1
            else:
                hm[genre] += 1

            # update the count of the favourite genre for this user
            if hm[genre] > fav_genre_count_for_user:
                fav_genre_count_for_user = hm[genre]

        # create a list of favorite genres for the user using fav_genre_count_for_user counter
        fav_genres_for_user = []
        for genre in hm:        # O(G)
            if hm[genre] == fav_genre_count_for_user:
                fav_genres_for_user.append(genre)

        sol[user] = fav_genres_for_user

    return sol


# Driver Code taken from https://leetcode.com/playground/xHv24v2Q

if __name__ == "__main__":
    userSongs = {
        "David": ["song1", "song2", "song3", "song4", "song8", "song9"],
        "Emma":  ["song5", "song6", "song7", "song10"]
    }
    songGenres = {
        "Rock":    ["song1", "song3"],
        "Dubstep": ["song7", "song10"],
        "Techno":  ["song2", "song4"],
        "Pop":     ["song5", "song6"],
        "Jazz":    ["song8", "song9"]
    }
    # output = {
    #     "David": ["Rock", "Techno"],
    #     "Emma":  ["Pop"]
    # }
    result = favorite_genres(userSongs, songGenres)
    print(result)
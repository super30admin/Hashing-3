# Problem2 Favourite Genres
# Time Complexity: O(U * S) where U is number of users and S is number of songs per user. We loop through every song for every user once and genre lookups are O(1) dictionary gets
# Space Complexity: O(S) where S is total number of songs.The songtogenremap stores one entry per song across all genres, which dominates the space used
# Approach:
# First we map each song to its genre using the genreMap, so we can look up any song's genre instantly
# Then for every user, we count how many songs they have per genre using a frequency map
# The genre(s) with the highest count are added to that user's favorite list

def favoritegenre(userMap, genreMap):
    songtogenremap = {}         # this will map each song to its one genre, so lookups are instant later
    for genre in genreMap:                  # go through each genre name, like "Rock", "Techno", etc
        for song in genreMap[genre]:        # go through each song inside that genre's list
            songtogenremap[song] = genre     # record that this song belongs to this genre

    result = {}                 # this will hold the final answer, user mapped to their favorite genre(s)
    for user in userMap:        # go through each user one at a time
        result[user] = []        # start this user with an empty list of favorite genres
        songs = userMap[user]       # grab this user's list of songs to make it easier to loop over

        freqmap = {}            # counts how many songs this specific user has per genre
        max_count = 0            # tracks the highest genre count seen so far for this user

        for song in songs:                  # go through each song this user listened to
            genre = songtogenremap.get(song)            # look up the genre for this song using our fast map
            freqmap[genre] = freqmap.get(genre, 0) + 1      # bump this genre's count by one, starting at 0 if new
            max_count = max(max_count, freqmap[genre])      # update max_count if this genre just became the new highest

        for genre in freqmap:                   # go through every genre this user has a count for
            if freqmap[genre] == max_count:      # check if this genre matches the highest count
                result[user].append(genre)      # if so, it is one of the user's favorite genres

    return result        # after processing every user, hand back the completed map


userSongs = {
    "David": ["song1", "song2", "song3", "song4", "song8"],
    "Emma": ["song5", "song6", "song7"]
}
songGenres = {
    "Rock": ["song1", "song3"],
    "Dubstep": ["song7"],
    "Techno": ["song2", "song4"],
    "Pop": ["song5", "song6"],
    "Jazz": ["song8", "song9"]
}
res = favoritegenre(userSongs, songGenres)
print(res)
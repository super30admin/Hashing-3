def favoriteGenre(userSongs, songGenres):
    result = dict()
    songsTogenre = dict()

    for genre in songGenres.keys():
        songs = songGenres.get(genre)
        for song in songs:
            songsTogenre[song] = genre

    # countMap = dict()
    for user in userSongs.keys():
        result[user] = []
        countMap = dict()
        maxCount = 0
        songs = userSongs.get(user)
        for song in songs:
            genre = songsTogenre.get(song)
            countMap[genre] = countMap.get(genre, 0) + 1
            maxCount = max(maxCount, countMap.get(genre))

        for genre in countMap.keys():
            if countMap.get(genre) == maxCount:
                result[user].append(genre)

    return result


class Solution(object):
    pass


def main():
    userSongs = {
    "David": ["song1", "song2", "song3", "song4", "song8"],
        "Emma":  ["song5", "song6", "song7"]}
    songGenres = {
        "Rock":    ["song1", "song3"],
        "Dubstep": ["song7"],
        "Techno":  ["song2", "song4"],
        "Pop":     ["song5", "song6"],
        "Jazz":    ["song8", "song9"]}

    solution = Solution()
    res = favoriteGenre(userSongs, songGenres)
    print(res)

if __name__ == "__main__":
    main()

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

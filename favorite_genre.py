from collections import defaultdict


class Solution:

    def favorite_genre(self, users, genres):
        """
            Time Complexity - O(m*(k2+n)+nk1)
            k1 -> avg for each genre
            k2 -> avg for each user
            n -> no of genres
            m -> no of users
            Space Complexity -
        """
        result = defaultdict(list)
        song_dic = {}
        for genre, songs in genres.items():  # O(nk1)
            for song in songs:
                song_dic[song] = genre
        for user in users:  # O(m*(k2+n))
            max_count = 0
            user_songs = defaultdict(int)
            for song in users[user]:
                user_songs[song_dic[song]] += 1
                max_count = max(max_count, user_songs[song_dic[song]])
            for genre, count in user_songs.items():
                if count == max_count:
                    result[user].append(genre)
        return dict(result)


if __name__ == '__main__':
    users = {'David': ['song1', 'song2', 'song3', 'song4', 'song8'],
             'Emma': ['song5', 'song6', 'song7']}
    genres = {'Rock': ['song1', 'song3'],
              'Dubstep': ['song7'],
              'Techno': ['song2', 'song4'],
              'Pop': ['song5', 'song6'],
              'Jazz': ['song8', 'song9']}
    print(Solution().favorite_genre(users, genres))

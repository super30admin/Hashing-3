class Solution:
	def __init__(self, songGenre):
		# create a map for user songs and song genre.
		self.genreSongs = {}
		for genre in songGenre:
			for song in songGenre[genre]:
				self.genreSongs[song] = genre  

	def favorite_genre(self, userSongs):	
		userGenreMap, userGenreRes = {}, {}
		for user in userSongs:
			userGenreMap[user]={}
			userGenreRes[user]=set()
			maxcount = 0

			# user genre mapping
			for song in userSongs[user]:
				genre = self.genreSongs[song]
				if genre not in userGenreMap[user]:
					userGenreMap[user][genre] = 0 
				userGenreMap[user][genre] += 1
				maxcount = max(maxcount, userGenreMap[user][genre])

			# add the genre to the result.
			for genre in userGenreMap[user]:
				if userGenreMap[user][genre]==maxcount:
					userGenreRes[user].add(genre)
		return userGenreRes


if __name__ == "__main__":
	userSongs = {	"David": ["song1", "song2", "song3", "song4", "song8"],
		"Emma": ["song5", "song6", "song7"]
	}

	songGenres = {
		"Rock": ["song1", "song3"],
		"Dubstep": ["song7"],
		"Techno": ["song2", "song4"],
		"Pop": ["song5", "song6"],
		"Jazz": ["song8", "song9"]
	}

	s = Solution(songGenres)
	userGenreResult = s.favorite_genre(userSongs)
	print(userGenreResult)


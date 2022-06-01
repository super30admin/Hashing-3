package main

import (
	"fmt"
)

func main() {
	fmt.Println(favoriteGenres(
		map[string][]string{
			"David": {"song1", "song2", "song3", "song4", "song8"},
			"Emma":  {"song5", "song6", "song7"},
		},
		map[string][]string{
			"Rock":    {"song1", "song3"},
			"Dubstep": {"song7"},
			"Techno":  {"song2", "song4"},
			"Pop":     {"song5", "song6"},
			"Jazz":    {"song8", "song9"},
		}))
}

// m = number of songs
// n = number of users
// time : o(mn)
// space: o(m)
func favoriteGenres(users map[string][]string, songsMap map[string][]string) map[string][]string {
	songToGenre := map[string]string{} // o(m) space
	// here we see all songs once -- o(m)
	for genre, songs := range songsMap {
		for _, song := range songs {
			songToGenre[song] = genre
		}
	}

	// { user : [genre1, genre2]
	tmp := map[string]*set{}
	// for each user o(n)
	for user, songs := range users {

		genreFreqMap := map[string]int{}
		max := 0
		// we loop over each user's songs list  o(m)
		// so far total time: o(mn)
		for _, song := range songs {
			genreFreqMap[songToGenre[song]]++
			if val := genreFreqMap[songToGenre[song]]; val > max {
				max = genreFreqMap[songToGenre[song]]
			}
		}

		for genre, count := range genreFreqMap {
			if count == max {
				if tmp[user] == nil {
					tmp[user] = newSet()
				}
				tmp[user].add(genre)
			}
		}

	}
	favorites := map[string][]string{}
	for k, v := range tmp {
		favorites[k] = v.toList()
	}
	return favorites
}

type set struct {
	items map[string]struct{}
}

func newSet() *set {
	return &set{map[string]struct{}{}}
}
func (s *set) add(key string) {
	s.items[key] = struct{}{}
}
func (s *set) delete(key string) {
	delete(s.items, key)
}
func (s *set) toList() []string {
	var out []string
	for k, _ := range s.items {
		out = append(out, k)
	}
	return out
}

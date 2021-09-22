// Time Complexity : O(mn), m -> Number of users, n -> Number of songs
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavouriteGenres {
	public Map<String, List<String>> favouriteGenre(Map<String, List<String>> userMap,
			Map<String, List<String>> genreMap) {
		if (userMap == null || userMap.size() == 0 || genreMap == null || genreMap.size() == 0) {
			return new HashMap<>();
		}

		Map<String, List<String>> result = new HashMap<>();
		Map<String, String> songToGenreMap = new HashMap<>();

		for (String genre : genreMap.keySet()) {
			List<String> songs = genreMap.get(genre);
			for (String song : songs) {
				songToGenreMap.put(song, genre);
			}
		}

		Map<String, Integer> genreCntMap;
		int maxCnt = 0;

		for (String user : userMap.keySet()) {
			genreCntMap = new HashMap<>();
			maxCnt = 0;
			result.put(user, new ArrayList<>());

			List<String> songs = userMap.get(user);
			for (String song : songs) {
				String genre = songToGenreMap.get(song);
				genreCntMap.put(genre, genreCntMap.getOrDefault(genre, 0) + 1);
				maxCnt = Math.max(maxCnt, genreCntMap.get(genre));
			}

			for (String genre : genreCntMap.keySet()) {
				if (genreCntMap.get(genre) == maxCnt) {
					result.get(user).add(genre);
				}
			}

		}

		return result;
	}

	private void print(Map<String, List<String>> map) {
		for (String key : map.keySet()) {
			System.out.print("\'" + key + "\' -> ");
			for (String genre : map.get(key)) {
				System.out.print(genre + ",");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		FavouriteGenres obj = new FavouriteGenres();

		Map<String, List<String>> userSongs = new HashMap<>();
		Map<String, List<String>> songGenres = new HashMap<>();

		userSongs.put("David", Arrays.asList(new String[] { "song1", "song2", "song3", "song4", "song8" }));
		userSongs.put("Emma", Arrays.asList(new String[] { "song5", "song6", "song7" }));

		songGenres.put("Rock", Arrays.asList(new String[] { "song1", "song3" }));
		songGenres.put("Dubstep", Arrays.asList(new String[] { "song7" }));
		songGenres.put("Techno", Arrays.asList(new String[] { "song2", "song4" }));
		songGenres.put("Pop", Arrays.asList(new String[] { "song5", "song6" }));
		songGenres.put("Jazz", Arrays.asList(new String[] { "song8", "song9" }));

		Map<String, List<String>> userGenres = obj.favouriteGenre(userSongs, songGenres);
		System.out.println("Users and their favourite Genres: ");
		obj.print(userGenres);
	}

}

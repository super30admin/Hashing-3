import java.util.*;

// Time Complexity : O(m*n) where m = number of users, n = number of songs
// Space Complexity : O(n) where n = number of songs
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Time Complexity : O(m*n) where m = number of users, n = number of songs
// Space Complexity : O(n) where n = number of songs

public class Main {
	public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap,
			Map<String, List<String>> genreMap) {
		HashMap<String, List<String>> result = new HashMap<>();

		HashMap<String, String> songToGenre = new HashMap<>();
		HashMap<String, Integer> countMap;

		for (String genre : genreMap.keySet()) {
			List<String> songs = genreMap.get(genre);

			for (String song : songs) {
				songToGenre.put(song, genre);
			}
		}

		for (String user : userMap.keySet()) {
			List<String> listenedSongs = userMap.get(user);
			countMap = new HashMap<>();
			int max = 0;

			for (String song : listenedSongs) {
				String genre = songToGenre.get(song);
				countMap.put(genre, countMap.getOrDefault(genre, 0) + 1);
				max = Math.max(max, countMap.get(genre));
			}

			result.put(user, new ArrayList<>());

			for (String genre : countMap.keySet()) {
				if (countMap.get(genre) == max) {
					result.get(user).add(genre);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		HashMap<String, List<String>> userSongs = new HashMap<>();
		userSongs.put("David", Arrays.asList(new String[] { "song1", "song2", "song3", "song4", "song8" }));
		userSongs.put("Emma", Arrays.asList(new String[] { "song5", "song6", "song7" }));

		HashMap<String, List<String>> songGenres = new HashMap<>();
		songGenres.put("Rock", Arrays.asList(new String[] { "song1", "song3" }));
		songGenres.put("Dubstep", Arrays.asList(new String[] { "song7" }));
		songGenres.put("Techno", Arrays.asList(new String[] { "song2", "song4" }));
		songGenres.put("Pop", Arrays.asList(new String[] { "song5", "song6" }));
		songGenres.put("Jazz", Arrays.asList(new String[] { "song8", "song9" }));
		Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

		System.out.println(res);
	}
}
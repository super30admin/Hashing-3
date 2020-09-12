//Time Complexity: O(M x N) where M is users and N is songs
//Space Complexity: O(Max(M, N))

import java.util.*;

public class Favorite_genre {
	public static Map<String, List<String>> favoriteGenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
		Map<String, List<String>> result = new HashMap<>();
		Map<String, String> songToGenre = new HashMap<>();
		for (String genre : genreMap.keySet()) {
			List<String> allSongs = genreMap.get(genre);
			for (String song : allSongs) {
				songToGenre.put(song, genre);
			}
		}
		HashMap<String, Integer> count;
		for (String user : userMap.keySet()) {
			List<String> likedSongs = userMap.get(user);
			count = new HashMap<>();
			int max = 0;
			result.put(user, new ArrayList<>());
			for (String song : likedSongs) {
				String genre = songToGenre.get(song);
				int cnt = count.getOrDefault(genre, 0) + 1;
				max = Math.max(max, cnt);
				count.put(genre, cnt);
			}
			for (String genre : count.keySet()) {
				if (count.get(genre) == max) {
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
		songGenres.put("DubStep", Arrays.asList(new String[] { "song7" }));
		songGenres.put("Techno", Arrays.asList(new String[] { "song2", "song4" }));
		songGenres.put("Pop", Arrays.asList(new String[] { "song5", "song6" }));
		songGenres.put("Jazz", Arrays.asList(new String[] { "song8", "song9" }));
		Map<String, List<String>> result = favoriteGenre(userSongs, songGenres);
		System.out.println(result);
	}
}
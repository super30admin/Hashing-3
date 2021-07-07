// Time complexity is O(m*K1 + n*(K2+n) where K1 and K2 are the songs in m and n
// Space complexity is o(mn)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BigN165FavouriteGenre {
	public HashMap<String, List<String>> favouriteGenre(HashMap<String, List<String>> users,
			HashMap<String, List<String>> genres) {
		HashMap<String, String> songsToGenre = new HashMap<>();
		for (String genre : genres.keySet()) {
			List<String> songs = genres.get(genre);
			for (String song : songs) {
				songsToGenre.put(song, genre);
			}
		}

		HashMap<String, List<String>> result = new HashMap<>();
		int max = 0;
		for (String user : users.keySet()) {
			result.put(user, new ArrayList<>());
			HashMap<String, Integer> temp = new HashMap<>();
			List<String> songs = users.get(user);
			for (String song : songs) {
				String cato = songsToGenre.get(song);
				int newCount = temp.getOrDefault(cato, 0) + 1;
				temp.put(cato, newCount);
				max = Math.max(max, newCount);
			}
			for (String s : temp.keySet()) {
				if (temp.get(s) == max) {
					result.get(user).add(s);
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
		BigN165FavouriteGenre fav = new BigN165FavouriteGenre();
		HashMap<String, List<String>> users = new HashMap<String, List<String>>();
		HashMap<String, List<String>> genres = new HashMap<String, List<String>>();
		users.put("David", Arrays.asList(new String[] { "song1", "song2", "song3", "song4", "song8" }));
		users.put("Emma", Arrays.asList(new String[] { "song5", "song6", "song7" }));
		genres.put("Rock", Arrays.asList(new String[] { "song1", "song3" }));
		genres.put("Dubstep", Arrays.asList(new String[] { "song7" }));
		genres.put("Techno", Arrays.asList(new String[] { "song2", "song4" }));
		genres.put("Pop", Arrays.asList(new String[] { "song5", "song6" }));
		genres.put("Jazz", Arrays.asList(new String[] { "song8", "song9" }));
		HashMap<String, List<String>> rs = fav.favouriteGenre(users, genres);
		System.out.println(rs);
	}
}
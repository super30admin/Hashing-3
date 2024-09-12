// Time Complexity : O(n*k1 + m*(k2+n)) where n is the number of genres, k1 is the avg number of songs per 
// genre, m is the number of users, k2 is the avg number of songs per user
// Space Complexity : O(m*n) where n is the number of genres and m is the number of users
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;

class favoriteGenres {

	public static HashMap<String, List<String>> favoriteGenres(HashMap<String, List<String>> userSongs, HashMap<String, List<String>> songGenres) {
		HashMap<String, List<String>> ans = new HashMap<>();
		HashMap<String, String> genreMap = new HashMap<>();
		for (String genre : songGenres.keySet()) {
			for (String song : songGenres.get(genre)) {
				genreMap.put(song, genre);
			}
		}
		for (String user : userSongs.keySet()) {
			ans.put(user, new ArrayList<>());
			List<String> songs = userSongs.get(user);
			HashMap<String, Integer> count = new HashMap<>();
			int max = 0;
			for (String song : songs) {
				String genre = genreMap.get(song);
				int newCount = count.getOrDefault(genre, 0) + 1;
				count.put(genre, newCount);
				max = Math.max(max, newCount);
			}
			for (String genre : count.keySet()) {
				if (max == count.get(genre)) {
					ans.get(user).add(genre);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		HashMap<String, List<String>> userSongs = new HashMap<>();
		userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));
		userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));
		HashMap<String, List<String>> songGenres = new HashMap<>();
		songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));
		songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));
		songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));
		songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));
		songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));
		HashMap<String, List<String>> ans = favoriteGenres(userSongs, songGenres);
		System.out.println(ans);	
	}
}

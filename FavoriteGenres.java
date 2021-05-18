// TC - O(n X m + q) --> n X m is to iterate over userSongs HashMap, q is to find maximum among genres to add to final list

// SC - O(number of songs)

package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavouriteGenres {
	public static void main(String[] args) {
		// Input given
		Map<String, ArrayList<String>> userSongs = new HashMap<>();
		
		userSongs.put("David", new ArrayList<String>(Arrays.asList("song1", "song2", "song3", "song4", "song7")));
		userSongs.put("Emma", new ArrayList<String>(Arrays.asList("song5", "song6", "song7")));
		
		Map<String, ArrayList<String>> songGenres = new HashMap<>();
		
		songGenres.put("Rock", new ArrayList<String>(Arrays.asList("song1", "song2", "song6")));
		songGenres.put("Pop", new ArrayList<String>(Arrays.asList("song3", "song5", "song7")));
		songGenres.put("Jazz", new ArrayList<String>(Arrays.asList("song4")));
		// Create a reverse mapping from song to genre, from songGenres hashmap
		Map<String, String> songToGenreMap = new HashMap<>();
		
		for(Map.Entry<String, ArrayList<String>> entry : songGenres.entrySet()) {
			String genre = entry.getKey();
			List<String> songs = entry.getValue();
			
			for(String song : songs) {
				songToGenreMap.put(song, genre);
			}
		}
		// create a result hashmap
		Map<String, ArrayList<String>> result = new HashMap<>();
		// Iterate over usersongs and calculate rock, pop, jazz and maintain a max count and add this max count genre to list and put it in a hashmap
		for(Map.Entry<String, ArrayList<String>> entry : userSongs.entrySet()) {
			int rock = 0;
			int pop = 0;
			int jazz = 0;
			int max = 0;
			String user = entry.getKey();
			List<String> songs = entry.getValue();
			
			for(String song : songs) {
				if(songToGenreMap.get(song).equals("Rock")) {
					rock++;
					max = Math.max(max, rock);
				}else if(songToGenreMap.get(song).equals("Pop")) {
					pop++;
					max = Math.max(pop, max);
				}else if(songToGenreMap.get(song).equals("Jazz")) {
					jazz++;
					max = Math.max(max, jazz);
				}
			}
			
			ArrayList<String> list = new ArrayList<>();
			if(max == rock) {
				list.add("Rock");
			}
			if(max == pop) {
				list.add("Pop");
			}
			if(max == jazz) {
				list.add("Jazz");
			}
			
			result.put(user, list);
			
		}
		
		for(Map.Entry<String, ArrayList<String>> entry : result.entrySet()) {
			System.out.println(entry.getKey() +" " + entry.getValue());
		}
		
	}
}

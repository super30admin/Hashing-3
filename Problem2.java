where m is the number of users,
n is the number of genres
k1 is the average number of songs in each genre
k2 is the average number of songs heard by each user
// Time Complexity - O(m(k2+n) + nk1) 
// Space Complexity - nk1
// This Solution worked on local development environment

//https://leetcode.com/discuss/interview-question/373006
//Amazon | OA 2019 | Favorite Genres
import java.util.*;
import java.util.HashMap;
public class FavoriteGenres {
	
	public static void main(String args[]) {
		HashMap<String,List<String>> userSongs = new HashMap<String,List<String>>();
		userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
		userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));
		HashMap<String,List<String>> genres = new HashMap<String,List<String>>();
		genres.put("Rock", Arrays.asList("song1", "song3"));
		genres.put("Dubstep", Arrays.asList("song7"));
		genres.put("Techno", Arrays.asList("song2", "song4"));
		genres.put("Pop", Arrays.asList("song5", "song6"));
		genres.put("Jazz", Arrays.asList("song8", "song9"));
		System.out.println(Arrays.asList(favgenres(userSongs,genres)));
	}
	
	public static Map<String, List<String>> favgenres(HashMap<String,List<String>> userSongs,HashMap<String,List<String>> genres){
		HashMap<String,List<String>> result = new HashMap<>();
		HashMap<String,String> songenre = new HashMap<>();
		for(String genre : genres.keySet()) {
			List<String> songs = genres.get(genre);
			for(String song: songs){
				if(!songenre.containsKey(song)){
					songenre.put(song,genre);
				}
			}
		}
		for(String user : userSongs.keySet()) {
			result.put(user,new ArrayList<>());
			int max =0;
			HashMap<String,Integer> map = new HashMap<>();
			List<String> songs = userSongs.get(user);
			for(String song : songs) {
				if(songenre.containsKey(song)) {
					String genre = songenre.get(song);
					int count = map.getOrDefault(genre, 0)+1;
					max = Math.max(max, count);
					map.put(genre,count);
				}
			}
			for(String genre: map.keySet()) {
				if(map.get(genre) == max) {
					result.get(user).add(genre);
				}
			}
		}
		return result;
	}

}

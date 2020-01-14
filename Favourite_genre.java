

import java.util.*;

public class favourite_genre {
	public static void main(String[] args) {
		
	}
	
	public Map<String, List<String>> favourite_genre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
		Map<String, List<String>> res = new HashMap<>();
		
		Map<String, String> songs_genre = new HashMap<>();
		
		for(String genre : genreMap.keySet()){
			for(String song : genreMap.get(genre)){
				songs_genre.put(song, genre);
			}
		}
		
		Map<String, Integer> count = new HashMap();
	   	int max = 0;
	   	
	   	for(String user : userMap.keySet()) {
	           count = new HashMap();
	           max = 0;
	           res.put(user, new ArrayList());
	   		List<String> songs = userMap.get(user);
	   		for(String song : songs) {
	   			String genre = songs_genre.get(song);
	   			int c = count.getOrDefault(genre, 0) + 1;
	   			count.put(genre, c);
	               max = Math.max(c, max);
	   		}
	           for (String key : count.keySet()) {
	               if (count.get(key) == max) {
	                   res.get(user).add(key);
	               }
	           }
	   	}
	   	return res;
	   }
	}
		
		

// Repeated DNA Sequences
// Time complexity: O(n) where n = length of array
// Space Complexity: O(n) for map

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // base condition
        if (s == null || s.length() < 10) {
            return new ArrayList<>();
        }
        
        Map<String, Integer> map = new HashMap<>();
        List<String> output = new ArrayList<>();
        // loop over string
        for (int i=0; i+10 <= s.length(); i++) {
            // get substring
            String subStr = s.substring(i, i+10);
            // if substring present in map and its value is 1
            if (map.containsKey(subStr) && map.get(subStr) > 0) {
                // add to output list
                output.add(subStr);
                // change value to 0
                map.put(subStr, 0);
            } else if (!map.containsKey(subStr)) { // if map doesn't contain the substring
                map.put(subStr, 1); .. add it to map with value 1
            }
        }
        
        // return output list
        return output;
    }
}

// Favorite Genres
// Time Complexity: O(n^2) where n = number of users and songs
// Space Complexity: O(m) where m = list of songs

import java.util.*;

public class FavoriteGenre {
	
	public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
		Map<String, List<String>> result = new HashMap<>();
	   	Map<String, String> songsMapping = new HashMap<>();
	   	
	   	// song to genre mapping
	   	for(String genre : genreMap.keySet()) {
	   		for(String song : genreMap.get(genre)) {
	   			songsMapping.put(song, genre);
	   		}
	   	}
	   	
	   	// genre count mapping
	    Map<String, Integer> countMap = new HashMap();
	   	
	    // getting max genre and adding to result
	   	for(String user : userMap.keySet()) {
           countMap = new HashMap();
           int max = 0;
           result.put(user, new ArrayList());
           // mapping every genre to its corresponding count for every user
	   	   for(String song : userMap.get(user)) {
	   			String genre = songsMapping.get(song);
	   			int c = countMap.getOrDefault(genre, 0) + 1;
	   			countMap.put(genre, c);
	            max = Math.max(c, max);
	   		}
	   	   
	   	   // getting max genre count and adding to result
           for (String key : countMap.keySet()) {
               if (countMap.get(key) == max) {
                   result.get(user).add(key);
               }
           }
	   	}
	   	
	   	return result;
	}
	
	public static void main(String[] args) {
		FavoriteGenre obj = new FavoriteGenre();
		Map<String, List<String>> userMap = new HashMap<>();
		Map<String, List<String>> songGenres = new HashMap<>();
		
		List<String> list1 = new ArrayList<>() {
			{
				add("song1"); add("song2"); add("song3"); add("song4"); add("song8");
			}
		};
		List<String> list2 = new ArrayList<>() {
			{
				add("song5"); add("song6"); add("song7");
			}
		};
		userMap.put("David", list1);
		userMap.put("Emma", list2);
		
		List<String> list3 = new ArrayList<>() {
			{
				add("song1"); add("song3");
			}
		};
		List<String> list4 = new ArrayList<>() {
			{
				add("song7");
			}
		};
		List<String> list5 = new ArrayList<>() {
			{
				add("song2"); add("song4");
			}
		};
		List<String> list6 = new ArrayList<>() {
			{
				add("song5"); add("song6");
			}
		};
		List<String> list7 = new ArrayList<>() {
			{
				add("song8"); add("song9");
			}
		};
		songGenres.put("Rock", list3);
		songGenres.put("Dubstep", list4);
		songGenres.put("Techno", list5);
		songGenres.put("Pop", list6);
		songGenres.put("Jazz", list7);
		
		Map<String, List<String>> result = obj.favoritegenre(userMap, songGenres);
		
		for (String key : result.keySet()) {
			System.out.print(key+ ": ");
			for (String val : result.get(key)) {
				System.out.print(val + ", ");
			}
			System.out.println();
		}
	}
}

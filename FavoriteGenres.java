import java.util.*;
public class FavoriteGenres {
	
	public static void main(String args[]) {
		Map<String, List> userSongs = new HashMap<>();
		List<String> songs1 = new ArrayList<>();
		songs1.add("song1");
		songs1.add("song2");
		songs1.add("song3");
		songs1.add("song4");
		songs1.add("song8");
		
		userSongs.put("David", songs1);
		
		List<String> songs2 = new ArrayList<>();
		songs2.add("song5");
		songs2.add("song6");
		songs2.add("song7");
		
		userSongs.put("Emma", songs2);
		
		Map<String, List> songGenres = new HashMap<>();
		
		List<String> list1 = new ArrayList<>();
		list1.add("song1");
		list1.add("song3");
		songGenres.put("Rock", list1);
		
		List<String> list2 = new ArrayList<>();
		list2.add("song7");
		songGenres.put("Dubstep", list2);
		
		List<String> list3 = new ArrayList<>();
		list3.add("song2");
		list3.add("song4");
		songGenres.put("Techno", list3);
		
		List<String> list4 = new ArrayList<>();
		list4.add("song5");
		list4.add("song6");
		songGenres.put("Pop", list4);
		
		List<String> list5 = new ArrayList<>();
		list5.add("song8");
		list5.add("song9");
		songGenres.put("Jazz", list5);
		
		System.out.println(favGenre(userSongs, songGenres));
	}
	
	public static Map<String, List> favGenre(Map<String, List> userSongs, Map<String, List> songGenres) {
		Map<String, List> result = new HashMap<>(); // user: favgenre
		
		//create song: genre mapping
		Map<String,Set> songToGenreMapping = songToGenreMapping(songGenres); // one song can be mapped to multiple genres as well
		// create genre: frequency mapping for each user
		
		System.out.println(":song to genre mapping:"+songToGenreMapping);
		
		for(Map.Entry<String, List> usersong : userSongs.entrySet()) {
			String user = usersong.getKey();
			List<String> songs = usersong.getValue();
			
			// get genre list for each song and create genre to freq mapping
			Map<String, Integer> genres = new HashMap<>();
			for(String s : songs) {
				Set<String> currGenres = songToGenreMapping.get(s);
				for(String g : currGenres) {
					genres.put(g, genres.getOrDefault(g, 0)+1);
				}
			}
			
			System.out.println(":genre to freq mapping:"+genres);
			
			int maxFreq = 0;
			List<String> resGenre = new ArrayList<>();
			for(String genre : genres.keySet()) {
				int currFreq = genres.get(genre);
				if(currFreq > maxFreq) {
					maxFreq = currFreq;
					resGenre.clear();
					resGenre.add(genre);
				}
				else if(currFreq == maxFreq) {
					resGenre.add(genre);
				}
			}
			
			result.put(user, resGenre);
		}
		
		return result;
	}
	
	private static Map<String, Set> songToGenreMapping(Map<String, List> songGenres) {
		Map<String, Set> result = new HashMap<>();
		for(Map.Entry<String, List> entry : songGenres.entrySet()) {
			String genre = entry.getKey();
			List<String> songs = entry.getValue();
			
			Set<String> genres = new HashSet<>();
			for(String song : songs) {
				if(song != null && song.length() > 0) {
					if(result.containsKey(song)) {
						genres = result.get(song);
					}
					genres.add(genre);
					result.put(song,  genres);
				}
			}
		}
		
		return result;
	}

}


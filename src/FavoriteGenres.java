import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*userSongs = {  
		   "David": ["song1", "song2", "song3", "song4", "song8"],
		   "Emma":  ["song5", "song6", "song7"]
		},
		songGenres = {  
		   "Rock":    ["song1", "song3"],
		   "Dubstep": ["song7"],
		   "Techno":  ["song2", "song4"],
		   "Pop":     ["song5", "song6"],
		   "Jazz":    ["song8", "song9"]
		}

		Output: {  
		   "David": ["Rock", "Techno"],
		   "Emma":  ["Pop"]
		}*/

public class FavoriteGenres {
	public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap,
			Map<String, List<String>> genreMap) {

		HashMap<String, List<String>> resultmap = new HashMap<>(); // no extra space
		HashMap<String, String> songToGenre = new HashMap<>(); // extra space--> O(mxn) m-> songs n -> genre
 		HashMap<String, Integer> countmap;

		// songs to genre map
		// i.e S1 -> Rock
		// i.e. S3 --> Rock, S7 - dubstep, S2 -> Techno etc..
		for (String genre : genreMap.keySet()) {
			List<String> songs = genreMap.get(genre);
			for (String song : songs) {
				songToGenre.put(song, genre);
			}

		}
		// iterating user first then creating hashmap for each user as countmap
		// here we are counting genre in that particular user list song
		//if its max then we are adding in resultant map
		for (String user : userMap.keySet()) { //k users so O(k*m*n)
			countmap = new HashMap<String, Integer>();
			resultmap.put(user, new ArrayList<String>());
			List<String> userSongs = userMap.get(user);
			int max = 0;
			for (String song : userSongs) {
				String genreOfParticularSong = songToGenre.get(song);
				countmap.put(genreOfParticularSong, countmap.getOrDefault(genreOfParticularSong, 0) + 1);
				max = Math.max(max, countmap.get(genreOfParticularSong));

			}
			//getting the genre count 
			//if its equal to max then adding to result map
			for (String genre : countmap.keySet()) {
				if (countmap.get(genre) == max) {
					resultmap.get(user).add(genre);
				}
			}

		}

		return resultmap;

	}

}

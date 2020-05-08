// Time Complexity: O(U(S+G)), where U is the number of users, S is the number of songs per user, G is the genre frequency
// Space Complexity: O(S+U(S+G)), where U is the number of users, S is the number of songs per user, G is the genre frequency


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FavoriteGenres {
	
    HashMap<String, List<String>> favoriteVideoGenre(int numUsers, HashMap<String, List<String>> userSongsListenedTo, int numGenerated) {

    	System.out.println(userSongsListenedTo);
    	System.out.println(songGenres);

    	// create song to genre mapping
    	Map<String, String> songGenreMap = new HashMap<>();
    	for(Map.Entry<String, List<String>> entry: songGenres.entrySet()) {
    		String genre = entry.getKey();
    		List<String> songs = entry.getValue();
    		if(songs ==  null || songs.size() == 0) continue;
    		for(String song: songs) {
    			songGenreMap.put(song, genre);
    		}
    	}

    	// for each user, find most listened genres
    	HashMap<String, List<String>> userGenreMap = new HashMap<>();
    	for(Map.Entry<String, List<String>> entry: userSongsListenedTo.entrySet()) {
    		String user = entry.getKey();
    		List<String> songs = entry.getValue();
    		if(songs == null || songs.size() == 0) continue;

    		// create frequency map
    		Map<String, Integer> songGenreFrequencyMap = getGenreFrequencyMap(songs, songGenreMap);
    		List<String> mostHeardGenres = getMostHeardGenres(songGenreFrequencyMap); // find most red one
    		userGenreMap.put(user, mostHeardGenres);
    	}
    	return userGenreMap;
    }

    private Map<String, Integer> getGenreFrequencyMap(List<String> songs, Map<String, String> songGenreMap) {
    	Map<String, Integer> frequencyMap = new HashMap<>();
    	if(songs == null) return frequencyMap;

    	for(String song: songs) {
    		String genre = songGenreMap.get(song);
    		frequencyMap.put(genre, frequencyMap.getOrDefault(genre, 0) + 1);
    	}
    	return frequencyMap;
    }

    private List<String> getMostHeardGenres(Map<String, Integer> songGenreMap) {
    	List<String>mostHeardGenres = new LinkedList<>();
    	if(songGenreMap == null) return mostHeardGenres;
    	int max = Integer.MIN_VALUE;

    	for(Map.Entry<String, Integer> entry: songGenreMap.entrySet()) {
    		String genre = entry.getKey();
    		int count = entry.getValue();
    		if(max < count) {
    			mostHeardGenres = new LinkedList<>();
    			mostHeardGenres.add(genre);
    			max = count;
    		} else if (max == count) {
    			mostHeardGenres.add(genre);
    		}
    	}
    	return mostHeardGenres;
    }



    public static void main(String args[]) {
    	int numbers, numGenres;
    	HashMap<String, List<String>> userSongsListenedTo, songsGenres;
    	String user, genre;
    	List<String> songs;

    	numUsers = 3;
    	userSongsListenedTo = new HashMap<>();

    	user = "Fred"
    	songs = new LinkedList<>();
    	songs.add("song1");
    	songs.add("song2");
    	songs.add("song3");
    	userSongsListenedTo.put(user, songs);

    	user = "Jenie"
    	songs = new LinkedList<>();
    	songs.add("song4");
    	songs.add("song5");
    	userSongsListenedTo.put(user, songs);

    	user = "Rob"
    	songs = new LinkedList<>();
    	songs.add("song6");
    	userSongsListenedTo.put(user, songs);

    	numGenres = 3;
    	songsGenres = new HashMap<>();

    	user = "Rock"
    	songs = new LinkedList<>();
    	songs.add("song1");
    	songs.add("song2");
    	songsGenres.put(genre, songs);

    	user = "Pep"
    	songs = new LinkedList<>();
    	songs.add("song4");
    	songsGenres.put(genre, songs);

    	genre = "Jazz";
    	songs = new LinkedList<>();
    	songs.add("song2");
    	songs.add("song6");
    	songs.add("song5");
    	songsGenres.put(genre, songs);

    	FavoriteGenre fg = new FavoriteGenre();
    	HashMap<String, List<String>> favoriteVideoGenres = 
    	  fg.favoriteVideoGenre(numUsers, userSongsListenedTo, numGenres, songsGenres);
    	System.out.println(favoriteVideoGenres);
		
	}

}

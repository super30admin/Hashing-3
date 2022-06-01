import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Time Complexity : O(m.n); where m is number of songs and n is number of users
//Space Complexity : O(m)
public class FavouriteGenres { 
	/**Approach: Hashing**/	
	public Map<String, List<String>> getFavoriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres){
        //prepare song to genre map
        Map<String, String> songToGenre = new HashMap<>();
        for(String genre: songGenres.keySet()){            
            for(String song : songGenres.get(genre)){
                songToGenre.put(song, genre);
            }
        }
        //Prepare result and frequency map for user's favorite songs
        Map<String, List<String>> userToGenre = new HashMap<>();        
        for(String user: userSongs.keySet()){            
            Map<String, Integer> freqMap = new HashMap<>();
            int count=0;
            for(String song : userSongs.get(user)){
                String genre = songToGenre.get(song);                
                int freq = freqMap.getOrDefault(genre , 0) + 1;
                freqMap.put(genre, freq);
                count = Math.max(count, freq);
            }
            //Iterate over freq Map and add favorites to result.
            List<String> userGenres = new ArrayList<>();
            for(String genre : freqMap.keySet()){                 
                if(count == freqMap.get(genre)){
                    userGenres.add(genre);
                    userToGenre.put(user, userGenres);
                }
            }            
        }
        
        return userToGenre;
    }
	 
    
	// Driver code to test above
	public static void main (String[] args) {	
		FavouriteGenres ob  = new FavouriteGenres();	
		Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));
        
        Map<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Arrays.asList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));

        Map<String, List<String>> map= ob.getFavoriteGenres(userSongs, songGenres);
        System.out.println("Favorite genre(s) are:");
        for(String key : map.keySet()){
            List<String> list = map.get(key);
            System.out.println(key+" : "+ list);
        }  
	}
}

/* Time Complexity : O(max(m,n)) 
 * m - no. of users 
 * n - no. of songs */
/* Space Complexity : O(n) 
 * songsToGenre - Map */
// Did this code successfully run on Leetcode : Yes, with below test on leetcode playground.
// Any problem you faced while coding this :

public class Main {
    
    public static Map<String, List<String>> favoriteGenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {

    	Map<String, List<String>> res = new HashMap<>();

   	    Map<String, String> songsToGenre = new HashMap<>();
        
		//Create a map of songs to genre's
        for(String genre: genreMap.keySet()){
            List<String> songsInGenre = genreMap.get(genre);
            for(String song: songsInGenre){
                songsToGenre.put(song, genre);
            }
        }
        
		//Create freq map of genre's per user
		//Add the genre with max freq to the result as per user
        Map<String, Integer> freqMap;
        int max = 0;        
        for(String user: userMap.keySet()){
            res.put(user, new ArrayList<>());
            max = 0;
            freqMap = new HashMap<>();
            List<String> userSongs = userMap.get(user);
            for(String song: userSongs){
                String genre = songsToGenre.get(song);
                freqMap.put(genre, freqMap.getOrDefault(genre, 0) + 1);
                max = Math.max(max, freqMap.get(genre));
            }
            
            for(String genre: freqMap.keySet()){
                if(freqMap.get(genre) == max){
                    res.get(user).add(genre);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        HashMap<String, List<String>> userSongs = new HashMap<>();

            userSongs.put("A", Arrays.asList(new String[]{"song4", "song2", "song7", "song9", "song10"}));

            userSongs.put("B", Arrays.asList(new String[]{"song2", "song1", "song3", "song12"}));
        
            userSongs.put("C", Arrays.asList(new String[]{"song5", "song3", "song6", "song8"}));

        HashMap<String, List<String>> songGenres = new HashMap<>();

            songGenres.put("Rock", Arrays.asList(new String[]{"song5", "song7", "song6", "song8"}));

            songGenres.put("Jazz", Arrays.asList(new String[]{"song11"}));

            songGenres.put("Techno", Arrays.asList(new String[]{"song1", "song9", "song10", "song2"}));

            songGenres.put("Pop", Arrays.asList(new String[]{"song3", "song12", "song4"}));

        Map<String, List<String>> res = favoriteGenre(userSongs, songGenres);

        System.out.println(res);
    }
}
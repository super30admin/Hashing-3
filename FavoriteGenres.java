// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// "static void main" must be defined in a public class.
public class Main {
    
    private static HashMap<String, List<String>> findGenres(HashMap<String, List<String>> userSongs, HashMap<String, List<String>> songGenres) {
        
        HashMap<String, String> songToGenre = new HashMap<>();
        
        for(String genre : songGenres.keySet()) {
            List<String> songs = songGenres.get(genre);
            for(String song : songs) {
                songToGenre.put(song, genre);
            }
        }
        
        HashMap<String, List<String>> result = new HashMap<>();
        
        for(String user: userSongs.keySet()) {
            
            List<String> songs = userSongs.get(user);
            HashMap<String, Integer> count = new HashMap<>();
            int max = 0;
            
            for(String song : songs) {
                String genreSong = songToGenre.get(song);
                count.put(genreSong, count.getOrDefault(genreSong, 0) + 1);
                max = Math.max(max, count.get(genreSong));
            }
            
            for(String genre : count.keySet()) {
                if(max == count.get(genre)) {
                    if(!result.containsKey(user)) {
                        result.put(user, new ArrayList<>());
                    }
                    result.get(user).add(genre);
                }
            }
            
        }
        return result;
        
    }
    
    public static void main(String[] args) {
        
        HashMap<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList(new String[] {"song1", "song2", "song3", "song4"}));
        userSongs.put("Malcolm", Arrays.asList(new String[] {"song2", "song5", "song6", "song7"}));
        userSongs.put("Reed", Arrays.asList(new String[] {"song1", "song6", "song8"}));
        
        HashMap<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList(new String[] {"song1", "song2", "song3"}));
        songGenres.put("Pop", Arrays.asList(new String[] {"song4", "song5", "song6"}));
        songGenres.put("Jazz", Arrays.asList(new String[] {"song7", "song8"}));
        
        System.out.println(findGenres(userSongs, songGenres));
        
    }
}
// Time Complexity : O(n^2 + m^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
public class Solution {
    
    public Map<String, List<String>> getFavouriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres){
        
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> songstogenre = new HashMap<>();

        for(String genre : songGenres.keySet()) {
            List<String> songs = songGenres.get(genre);
            for(String song : songs) {
                songstogenre.put(song, genre);
            }
        }
        
        Map<String, Integer> count = new HashMap();
   	    int max = 0;
        
        for(String user : userSongs.keySet()) {
           count = new HashMap();
           max = 0;
           res.put(user, new ArrayList());
   		    List<String> songs = userSongs.get(user);
            for(String song : songs) {
                String genre = songstogenre.get(song);
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
    
    
    
    public static void main(String[] args) {
        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8")); 
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7")); 
        
        Map<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3")); 
        songGenres.put("Dubstep", Arrays.asList("song7")); 
        songGenres.put("Techno", Arrays.asList("song2", "song4")); 
        songGenres.put("Pop", Arrays.asList("song5", "song6")); 
        songGenres.put("Jazz", Arrays.asList("song8", "song9")); 
        
        Map<String, List<String>> res = new Solution().getFavouriteGenres(userSongs, songGenres);

        System.out.println("Res: "+ res);
    }
}
//u - users, s = songs, g - generes, n - avg songs per genres
// Time Complexity : O(u*s + g*n)
// Space Complexity : O(u*s + g*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Main {
    public static void main(String[] args) {
        HashMap<String , List<String>> userSongs = new HashMap<>();
        HashMap<String , List<String>> songGenres = new HashMap<>();
        userSongs.put("David", Arrays.asList("Song1", "Song4", "Song5", "Song8"));
        userSongs.put("Jim", Arrays.asList("Song2", "Song3", "Song6"));
        userSongs.put("Kimberly", Arrays.asList("Song1", "Song7"));
        userSongs.put("Jane", Arrays.asList("Song9", "Song4"));
        
        songGenres.put("Jazz", Arrays.asList("Song1", "Song2", "Song5"));
        songGenres.put("Pop", Arrays.asList("Song3", "Song4", "Song6"));
        songGenres.put("Rock", Arrays.asList("Song7", "Song8", "Song9"));
        
        System.out.println(findFavGenres(userSongs, songGenres));
    }
    
    public static HashMap<String, List<String>> findFavGenres(HashMap<String, List<String>> userSongs, HashMap<String, List<String>> songGenres){
        HashMap<String,String> songToGenres = new HashMap<>();
        
        for(String genres : songGenres.keySet()){
            List<String> songs = songGenres.get(genres);
            for(String song : songs){
                songToGenres.put(song, genres);
            }
        }
        
        HashMap<String, List<String>> result = new HashMap<>();
        
        for(String user : userSongs.keySet()){
            HashMap<String, Integer> freq= new HashMap<>();
            int max = 0;
            
            List<String> songs = userSongs.get(user);
            for(String song: songs){
                String genre = songToGenres.get(song);
                freq.put(genre, freq.getOrDefault(genre, 0)+1);
                max = Math.max(max, freq.get(genre));
            }
            result.put(user, new ArrayList<>());
            for(String key : freq.keySet()){
                if(max == freq.get(key)){
                    result.get(user).add(key);
                }
            }
        }
        return result;
    }
}
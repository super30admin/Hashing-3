// Time Complexity : O(m*k+N) where m = number of user, k=avergae length of songs heard by each user
   // and N= total number of songs
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : First use the songGenres map to create map of song to genre. For each user maintian a hashmap of genres and counts
/// Add the most highest present genre to result
// "static void main" must be defined in a public class.
/*
Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.

Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.

The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.
*/
public class FavoriteGenres {
    public static void main(String[] args) {
        HashMap<String, String[]> userSongs = new HashMap<>();
        userSongs.put("David", new String[]{"song1", "song2", "song3", "song4", "song8"});
        userSongs.put("Emma", new String[]{"song5", "song6", "song7"});
        HashMap<String, String[]> songGenres = new HashMap<>();
        songGenres.put("Rock", new String[]{"song1", "song3"});
        songGenres.put("Dubstep", new String[]{"song7"});
        songGenres.put("Techno", new String[]{"song2", "song4"});
        songGenres.put("Pop", new String[]{"song5", "song6"});
        songGenres.put("Jazz", new String[]{"song8", "song9"});
        HashMap<String, List<String>> result = solve(userSongs, songGenres);
        for(String user: result.keySet()){
            System.out.println(user+"->"+result.get(user));
        }
    }
    public static HashMap<String, List<String>> solve(HashMap<String, String[]> userSongs, HashMap<String, String[]> songGenres){
        HashMap<String, String> songs = new HashMap<>();
        HashMap<String, List<String>> result = new HashMap<>();
        for(String genre : songGenres.keySet()){
            for(String song:songGenres.get(genre)){
                songs.put(song, genre);
            } 
        }
        for(String user: userSongs.keySet()){
            HashMap<String, Integer> genreMap = new HashMap<>();
            int count = 0;
            result.put(user, new ArrayList<String>());
            for(String song: userSongs.get(user)){
                String genre = songs.get(song);
                if(!genreMap.containsKey(genre)){
                    genreMap.put(genre, 0);
                }
                genreMap.put(genre, genreMap.get(genre)+1);
                count = Math.max(count, genreMap.get(genre));
            }
            for(String genre: genreMap.keySet()){
                if(genreMap.get(genre) == count){
                   result.get(user).add(genre);
                }
            }
        }
        return result;
    }
}
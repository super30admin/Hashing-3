import java.util.*;
/*
Time Complexity: O(N*M), N is the number of genres and M is the songs in each genre
Space Complexity: O(N) using HashMap
Any difficulties: no

Approach:
1. Attempted once discussed in the class
 */
public class FavoriteGenres {
    public static HashMap<String, List<String>> favoriteGenre(HashMap<String, List<String>> userMap,
                                                          HashMap<String, List<String>> genreMap) {
        HashMap<String, List<String>> result = new HashMap<>();
        HashMap<String, String> songsToGenre = new HashMap<>();
        for(String genre : genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            for(String song : songs) {
                songsToGenre.put(song, genre);
            }
        }
        HashMap<String, Integer> countMap ;
        int max = 0;
        for(String user : userMap.keySet()) {
            countMap = new HashMap();
            max = 0;
            result.put(user, new ArrayList());
            List<String> songs = userMap.get(user);
            for(String song : songs) {
                String genre = songsToGenre.get(song);
                int c = countMap.getOrDefault(genre, 0) + 1;
                countMap.put(genre, c);
                max = Math.max(c, max);
            }
            for (String key : countMap.keySet()) {
                if (countMap.get(key) == max) {
                    result.get(user).add(key);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        HashMap<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));
        userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));
        HashMap<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));
        songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));
        songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));
        songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));
        songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));
        Map<String, List<String>> result = favoriteGenre(userSongs, songGenres);
        System.out.println(result);

    }
}

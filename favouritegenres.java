/*
Time Complexity: O(U*(S+G))
Space Complexity: O(S+(U*G)))
*/
import java.util.*;
class Solution {
    static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap,
            Map<String, List<String>> genreMap) {

        Map<String, List<String>> res = new HashMap<>(); // map<user, user's favor genre>
        Map<String, String> songstogenre = new HashMap<>();

        for (String genre : genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            for (String song : songs) {
                songstogenre.put(song, genre);
            }
        }

        for (String user : userMap.keySet()) {
            Map<String, Integer> count = new HashMap<>(); // map<genre, genre_count>
            int max = 0;
            res.put(user, new ArrayList<>());
            List<String> songs = userMap.get(user);
            for (String song : songs) {
                String genre = songstogenre.get(song);
                int c = count.getOrDefault(genre, 0) + 1;
                count.put(genre, c);
                max = Math.max(c, max);
            }
            for (String key : count.keySet()) {
                if (key!=null&&count.get(key) == max) { // if genre exists and is the most frequent one
                    res.get(user).add(key);
                }
            }
        }

        return res;
    }
}

public class MyClass {
    public static void main(String[] args) {
        Map<String, List<String>> userMap1 = new HashMap<>();
        userMap1.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userMap1.put("Emma", Arrays.asList("song5", "song6", "song7"));

        Map<String, List<String>> songGenres1 = new HashMap<>();
        songGenres1.put("Rock", Arrays.asList("song1", "song3"));
        songGenres1.put("Dubstep", Arrays.asList("song7"));
        songGenres1.put("Techno", Arrays.asList("song2", "song4"));
        songGenres1.put("Pop", Arrays.asList("song5", "song6"));
        songGenres1.put("Jazz", Arrays.asList("song8", "song9"));

        System.out.println("Result of test1:\n"+Solution.favoritegenre(userMap1, songGenres1));

        Map<String, List<String>> userMap2 = new HashMap<>();
        userMap2.put("David", Arrays.asList("song1", "song2"));
        userMap2.put("Emma", Arrays.asList("song3", "song4"));

        Map<String, List<String>> songGenres2 = new HashMap<>();

        System.out.println("Result of test2:\n"+Solution.favoritegenre(userMap2, songGenres2));
    }
}
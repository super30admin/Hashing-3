// Approach: Use 2 hashmaps
// Time: O(m+n) i.e. O(Max(m,n)) m = No. of users, n = No. of songs
// Space: O(m+n) i.e. O(Max(m,n))

import java.util.*;

public class FavoriteGenres {

    public static Map<String, List<String>> favoriteGenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {

        Map<String, List<String>> result = new HashMap<>();
        Map<String, String> songToGenre = new HashMap<>();

        for (String genre : genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);

            for (String song : songs) {
                songToGenre.put(song, genre);
            }
        }

        for (String user : userMap.keySet()) {
            result.put(user, new ArrayList<>());
            Map<String, Integer> countMap = new HashMap<>();
            List<String> songs = userMap.get(user);
            int max = 0;

            for (String song : songs) {
                String genre = songToGenre.get(song);
                countMap.put(genre, countMap.getOrDefault(genre, 0) + 1);
                max = Math.max(max, countMap.get(genre));
            }

            for (String genre : countMap.keySet()) {
                if (countMap.get(genre) == max) {
                    result.get(user).add(genre);
                }
            }
        }
        return  result;
    }
}
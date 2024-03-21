/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m*n)
    m = users
    n = songs
* 
* Space Complexity: O(n)
    n - total songs
* 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FavoriteGenres {
    public class Main {

        public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap,
                Map<String, List<String>> genreMap) {

            HashMap<String, String> songsToGenre = new HashMap<>();

            for (String genre : genreMap.keySet()) {
                for (String song : genreMap.get(genre)) {
                    songsToGenre.put(song, genre);
                }
            }

            Map<String, List<String>> result = new HashMap<>();

            for (String user : userMap.keySet()) {
                result.put(user, new ArrayList<>());

                HashMap<String, Integer> genreCount = new HashMap<>();

                int maxGenreCount = 0;

                for (String song : userMap.get(user)) {
                    String songGenre = songsToGenre.get(song);

                    genreCount.put(songGenre, genreCount.getOrDefault(songGenre, 0) + 1);

                    maxGenreCount = Math.max(genreCount.get(songGenre), maxGenreCount);
                }

                for (String genre : genreCount.keySet()) {
                    if (genreCount.get(genre) == maxGenreCount) {
                        result.get(user).add(genre);
                    }
                }
            }

            return result;
        }

        public static void main(String[] args) {
            HashMap<String, List<String>> userSongs = new HashMap<>();

            userSongs.put("David", Arrays.asList(new String[] { "song1", "song2", "song3", "song4", "song8" }));

            userSongs.put("Emma", Arrays.asList(new String[] { "song5", "song6", "song7" }));

            HashMap<String, List<String>> songGenres = new HashMap<>();

            songGenres.put("Rock", Arrays.asList(new String[] { "song1", "song3" }));

            songGenres.put("Dubstep", Arrays.asList(new String[] { "song7" }));

            songGenres.put("Techno", Arrays.asList(new String[] { "song2", "song4" }));

            songGenres.put("Pop", Arrays.asList(new String[] { "song5", "song6" }));

            songGenres.put("Jazz", Arrays.asList(new String[] { "song8", "song9" }));

            Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

            System.out.println(res);
        }

    }

}

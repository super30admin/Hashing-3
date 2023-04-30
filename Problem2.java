import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
/*
Favorite Genres
approach: create a map of song to genre to make it simple and make genre freq map for each user
time: O(kn+mn)
space: O(m+k)
 */
public class Problem2 {
    private Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> songToGenre = new HashMap<>();

        for (String key:songGenres.keySet()) {
            List<String> songs = songGenres.get(key);

            for (String song: songs) {
                songToGenre.put(song, key);
            }
        }
        Map<String, Integer> songFreqMap = new HashMap<>();

        for (String user:userSongs.keySet()) {
            int max = 0;

            List<String> songs = userSongs.get(user);
            List<String> result = new ArrayList<>();
            for (String song:songs) {
                songFreqMap.put(songToGenre.get(song), songFreqMap.getOrDefault(songToGenre.get(song), 0)+1);

                if (max<songFreqMap.get(songToGenre.get(song))) {
                    result.clear();
                    result.add(songToGenre.get(song));
                    max = songFreqMap.get(songToGenre.get(song));
                }
                else if (max==songFreqMap.get(songToGenre.get(song))) {
                    result.add(songToGenre.get(song));
                }
            }
            res.put(user, result);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));
        Map<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Arrays.asList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));
        problem2.favoriteGenres(userSongs, songGenres);
    }
}

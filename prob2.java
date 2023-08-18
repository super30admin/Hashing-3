// Time Complexity : O(U+S)
// Space Complexity : O(S+G)

import java.util.*;

public class Main {

    public static Map<String, List<String>> favoriteGenre(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
        Map<String, String> songToGenre = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : songGenres.entrySet()) {
            String genre = entry.getKey();
            List<String> songs = entry.getValue();
            for (String song : songs) {
                songToGenre.put(song, genre);
            }
        }
        
        Map<String, List<String>> userFavoriteGenres = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : userSongs.entrySet()) {
            String user = entry.getKey();
            List<String> songs = entry.getValue();
            Map<String, Integer> genreCount = new HashMap<>();
            int maxCount = 0;
            for (String song : songs) {
                String genre = songToGenre.get(song);
                genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
                maxCount = Math.max(maxCount, genreCount.get(genre));
            }
            List<String> favoriteGenres = new ArrayList<>();
            for (Map.Entry<String, Integer> genreEntry : genreCount.entrySet()) {
                if (genreEntry.getValue() == maxCount) {
                    favoriteGenres.add(genreEntry.getKey());
                }
            }
            userFavoriteGenres.put(user, favoriteGenres);
        }
        
        return userFavoriteGenres;
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

        Map<String, List<String>> res = favoriteGenre(userSongs, songGenres);

        System.out.println(res);
    }
}

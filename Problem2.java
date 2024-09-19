//Time = O(nm)
//Space =   O(nm)

import java.util.*;

class Solution {
    public Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
        // Initialize a map to store each user's favorite genres
        Map<String, List<String>> favoriteGenres = new HashMap<>();
        
        // Initialize a map to store the genre of each song
        Map<String, String> songToGenre = new HashMap<>();
        for (String genre : songGenres.keySet()) {
            List<String> songs = songGenres.get(genre);
            for (String song : songs) {
                songToGenre.put(song, genre);
            }
        }
        
        // Iterate through each user's songs and count the number of times each genre appears
        for (String user : userSongs.keySet()) {
            List<String> songs = userSongs.get(user);
            Map<String, Integer> genreCount = new HashMap<>();
            int maxCount = 0;
            for (String song : songs) {
                String genre = songToGenre.get(song);
                int count = genreCount.getOrDefault(genre, 0) + 1;
                genreCount.put(genre, count);
                maxCount = Math.max(maxCount, count);
            }
            
            // Add the user's favorite genres to the map
            List<String> favorite = new ArrayList<>();
            for (String genre : genreCount.keySet()) {
                int count = genreCount.get(genre);
                if (count == maxCount) {
                    favorite.add(genre);
                }
            }
            favoriteGenres.put(user, favorite);
        }
        
        return favoriteGenres;
    }
}

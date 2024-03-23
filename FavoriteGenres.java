import java.util.*;

public class FavoriteGenres {
    // TC: O(M * K + N * K) where M is number of genres, K is number of songs and N is number of users
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, String> songToGenreMap = new HashMap<>();
        for (String genre : genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            for (String song : songs) {
                songToGenreMap.put(song, genre);
            }
        }
        Map<String, List<String>> result = new HashMap<>();
        for (String user : userMap.keySet()) {
            List<String> songs = userMap.get(user);
            List<String> favGenres = new ArrayList<>();
            Map<String, Integer> countMap = new HashMap<>();
            int maxFreq = 0;
            for (String song : songs) {
                String genre = songToGenreMap.get(song);
                countMap.put(genre, countMap.getOrDefault(genre, 0) + 1);
                if (countMap.get(genre) > maxFreq) {
                    favGenres = new ArrayList<>();
                    favGenres.add(genre);
                    maxFreq = countMap.get(genre);
                } else if (countMap.get(genre) == maxFreq) {
                    favGenres.add(genre);
                }
            }
            result.put(user, favGenres);
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

        Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

        System.out.println(res);
    }
}

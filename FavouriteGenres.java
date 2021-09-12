// Time Complexity : O(m * n) //m - users, n - songs
// Space Complexity : O(n)

import java.util.*;

class Genre {
    
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, List<String>> result = new HashMap<>();
        Map<String, String> songToGenre = new HashMap<>();
        Map<String, Integer> countMap;
        //create songToGenre Map for O(1) lookup
        for(String genre: genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            for(String song: songs){
                songToGenre.put(song, genre);
            }
        }
        
        for(String user: userMap.keySet()) {
            List<String> songs = userMap.get(user);
            countMap = new HashMap<>();
            int max = 0;
            for(String song: songs){
                String genre = songToGenre.get(song);
                countMap.put(genre, countMap.getOrDefault(genre, 0) + 1);
                max = Math.max(max , countMap.get(genre));
            }
            result.put(user, new ArrayList<>());
            for(String genre: countMap.keySet()) {
                if(countMap.get(genre) == max) {
                    result.get(user).add(genre);
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

        Map<String, List<String>> res = favoritegenre(userSongs, songGenres);
        System.out.println(res);
    }
}
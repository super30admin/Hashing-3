// time: O(No of user * No of songs) + O(No of songs == No of genres) | Space: O(No of Genres || No of songs)

import java.util.*;

public class FavoriteGenres {

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> songsToGenresMap = new HashMap<>();
        // taking song to genre map
        for(Map.Entry<String, List<String>> genre: genreMap.entrySet()) {
            List<String> songs = genre.getValue();
            for(String song: songs) {
                songsToGenresMap.put(song, genre.getKey());
            }
        }
        Map<String, Integer> genreFreq;
        // traversing on usermap
        for(Map.Entry<String, List<String>> user: userMap.entrySet()) {
            List<String> songs = user.getValue();
            genreFreq = new HashMap<>();
            int max = Integer.MIN_VALUE;
            // creating genre frequencies
            for(String song: songs) {
                String genre = songsToGenresMap.get(song);
                int freq = genreFreq.getOrDefault(genre, 0)+1;
                genreFreq.put(genre, freq);
                max = Math.max(max, freq);
            }
            // upon max, we create final res
            List<String> genreList = new ArrayList<>();
            for(Map.Entry<String, Integer> gf: genreFreq.entrySet()) {
                if(gf.getValue() == max) {
                    genreList.add(gf.getKey());
                }
            }
            res.put(user.getKey(), genreList);
        }
        return res;
    }

    public static void main(String[] args) {
        HashMap<String, List<String>> userSongs = new HashMap<>();

        userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));

        userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

        HashMap<String, List<String>> songGenres = new HashMap<>();

        songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));

        songGenres.put("Dubstep", Arrays.asList(new String[]{"song7", "song8"}));

        songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));

        songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));

        songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));

        Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

        System.out.println(res);//{David=[Rock, Techno], Emma=[Pop]}
    }
}
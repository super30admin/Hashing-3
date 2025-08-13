//time complexity- O(k*n) where k is users and n is the number of songs
//space complexity- O(n)
import java.util.*;
public class FavouriteGenres {
    static HashMap<String, List<String>> favoritegenre(HashMap<String, List<String>> userSongs, HashMap<String, List<String>> songGenres) {
        HashMap<String, List<String>> userGenre = new HashMap<>();
        HashMap<String, String > songToGenre = new HashMap<>();
        for(String geners: songGenres.keySet()) {
            for(String songs: songGenres.get(geners)) {
                songToGenre.put(songs, geners);
            }
        }
        for (String name: userSongs.keySet()) {
            userGenre.put(name, new ArrayList<>());
            HashMap<String, Integer> countMap = new HashMap<>();
            int max = 0;
            for (String songs: userSongs.get(name)) {
                String genre = songToGenre.get(songs);
                countMap.put(genre, countMap.getOrDefault(genre, 0)+1);
                max = Math.max(max, countMap.get(genre));
            }
            for (String genre: countMap.keySet()) {
                if(max == countMap.get(genre)) {
                    userGenre.get(name).add(genre);
                }
            }
        }
        return userGenre;
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

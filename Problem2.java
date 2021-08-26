
// Time - O(n^2)
// Space - O(n*n)


import java.util.*;

public class Problem2 {
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

    private static Map<String,List<String>> favoriteGenre(HashMap<String, List<String>> userSongs, HashMap<String, List<String>> songGenres) {

        Map<String,List<String>> result = new HashMap<>(); // result to output which would be user with the list of favorite genres

        HashMap<String, String> songToGenres = new HashMap<>(); // hashmap of song to genre list

        for(String genre: songGenres.keySet()) {
            List<String> songs = songGenres.get(genre);
            for(String song: songs) {
                songToGenres.put(song, genre);
            }
        }

        HashMap<String, Integer> countMap; // it is genre count

        for(String user: userSongs.keySet()) {

            result.put(user, new ArrayList<>()); // result would be user with list of favorite genres
            countMap = new HashMap<>(); // initialize genre count for each user
            List<String> userSong = userSongs.get(user);
            int max = 0;
            for(String usrsong: userSong) { // take the song which user likes
                String genre = songToGenres.get(usrsong); // grab the genre of users favorite songs
                countMap.put(genre, countMap.getOrDefault(genre,0) + 1); // add to the map genre to count of genre map
                max = Math.max(max,countMap.get(genre)); // calculate the max
            }

            for(String genre: countMap.keySet()) {
                if(countMap.get(genre) == max) { // if the count of genre is equal to max count
                    result.get(user).add(genre); // add the favorite genre to the list mapping to the user
                }
            }

        }

        return result;
    }

}

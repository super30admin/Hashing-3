import java.util.*;

public class FavoriteGenres {

    // Hashing - Four hash maps - Time O(m*n) and Space O(n)
    public static Map<String, List<String>> favoriteGenres(Map<String, List<String>> userToSong,
                                                           Map<String, List<String>> genreToSong) {

        // user to favorite genres
        Map<String, List<String>> result = new HashMap<>();

        // each song is in only one genre
        Map<String, String> songToGenre = new HashMap<>();       // O(n) space

        // song to genre map
        // iterate over genre to song map
        for(String genre: genreToSong.keySet()) {

            // list of songs in each genre
            List<String> songs = genreToSong.get(genre);

            // add song and genre to song to genre map
            for(String song: songs) {                      // O(n)

                songToGenre.put(song, genre);
            }
        }

        // iterate over user to song map
        for(String user: userToSong.keySet()) {             // O(m*n)

            // build genre frequency map
            HashMap<String, Integer> genreFrequency = new HashMap<>();   // O(k) space

            int maxFrequency = 0;

            List<String> songs = userToSong.get(user);

            // iterate over songs of each user
            for(String song: songs) {

                String genre = songToGenre.get(song);

                genreFrequency.put(genre, genreFrequency.getOrDefault(genre, 0) + 1);

                maxFrequency = Math.max(maxFrequency, genreFrequency.get(genre));
            }

            // initialise result for each user
            result.put(user, new ArrayList<>());

            // add maximum frequency genres to result
            for(String genre: genreFrequency.keySet()) {

                if(genreFrequency.get(genre) == maxFrequency) {

                    result.get(user).add(genre);
                }
            }
        }

        // output
        return result;

    }

    public static void main(String[] args) {

        FavoriteGenres obj = new FavoriteGenres();

        // user to song map
        HashMap<String, List<String>> userSongs = new HashMap<>();

        userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));
        userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

        // genre to song map
        HashMap<String, List<String>> songGenres = new HashMap<>();

        songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));
        songGenres.put("Dub step", Arrays.asList(new String[]{"song7"}));
        songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));
        songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));
        songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));

        Map<String, List<String>> answer = obj.favoriteGenres(userSongs, songGenres);

        for(String user: answer.keySet()) {

            System.out.print(user + ": ");

            for(String genre: answer.get(user)) {

                System.out.print(genre + " ");
            }
            System.out.println();
        }

    }
}

/*
Time Complexity = O(m*n)
Time = O(m*n) + O(n)

m = number of users
n = number of songs
k = number of genres

Space Complexity = O(n)
Space = O(n) + O(k)
*/

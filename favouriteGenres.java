// Time Complexity : O(max(mn, gn)), where m=users, n=songs, g=genre
// Space Complexity : O(n), where n=songs since it will occupy the most space map: songs to genres
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
import java.io.*;
import java.util.*;

class Main {
    private static HashMap<String, List<String>> getFavGenres(Map<String, List<String>> userToSongs, Map<String, List<String>> genreToSongs) {

        // Convert a map with key as song and value as genre,
        // so that we can easily get the genre of a particular song
        HashMap<String, String> songToGenre = new HashMap<>();
        for (String genre: genreToSongs.keySet()) {
            List<String> songs = genreToSongs.get(genre);
            for (String song: songs) {
                songToGenre.put(song, genre);
            }
        }

        // use a hashMap to store the frequency of each genre in the users songs
        HashMap<String, Integer> genreFreq = new HashMap<>();

        // Now create a map with key as user and value as the list of users favroite genre
        HashMap<String, List<String>> userFav = new HashMap<>();

        for (String user: userToSongs.keySet()) {
            genreFreq = new HashMap<>();
            List<String> songs = userToSongs.get(user);
            int max=0;
            for (String song: songs) {
                String genre = songToGenre.get(song);
                genreFreq.put(genre, genreFreq.getOrDefault(genre, 0) + 1);
                max = Math.max(max, genreFreq.get(genre));
            }

            for(String genre: genreFreq.keySet()) {
                if (max == genreFreq.get(genre)) {
                    if (!userFav.containsKey(user)) {
                        userFav.put(user, new ArrayList<>());
                    }
                    userFav.get(user).add(genre);
                }
            }
        }

        return userFav;
    }

    public static void main (String[] args) {
        HashMap<String, List<String>> userToSongs = new HashMap<>();
        userToSongs.put("David", new ArrayList<>(Arrays.asList("S1", "S2", "S3", "S5")));
        userToSongs.put("Emma", new ArrayList<>(Arrays.asList("S2", "S4", "S6", "S8")));
        userToSongs.put("Paula", new ArrayList<>(Arrays.asList("S9", "S10", "S11", "S5", "S7", "S12")));

        HashMap<String, List<String>> genreToSongs = new HashMap<>();
        genreToSongs.put("Pop", new ArrayList<>(Arrays.asList("S1", "S3", "S4")));
        genreToSongs.put("Rock", new ArrayList<>(Arrays.asList("S2", "S5", "S6")));
        genreToSongs.put("Jazz", new ArrayList<>(Arrays.asList("S9", "S8", "S10")));
        genreToSongs.put("Techno", new ArrayList<>(Arrays.asList("S11", "S7", "S12")));

        HashMap<String, List<String>> result = getFavGenres(userToSongs, genreToSongs);

        for (String user: result.keySet()) {
            System.out.println(user+" "+result.get(user));
        }
    }
}
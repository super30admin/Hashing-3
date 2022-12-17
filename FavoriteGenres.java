// Time Complexity: O(numberOfSongsInAllGenres) + O(number of users * averge number of songs a user listens too)
// Space Complexity: O(number of songs) + O(number of genres * number of Users)
// "static void main" must be defined in a public class.
public class Main {

    private static HashMap<String, List<String>> findFaveGenres(HashMap<String, List<String>> userToSongs, HashMap<String, List<String>> genreToSongs) {
        HashMap<String, String> songsToGenre = new HashMap<>();
        HashMap<String, List<String>> result = new HashMap<>();

        for (String genre: genreToSongs.keySet()) {
            List<String> songs = genreToSongs.get(genre);
            for (String song: songs) {
                songsToGenre.put(song, genre);
            }
        }

        for (String user: userToSongs.keySet()) {
            List<String> songs = userToSongs.get(user);
            HashMap<String, Integer> map = new HashMap<>();
            int max = 0;
            for (String song : songs) {
                String genre = songsToGenre.get(song);
                map.put(genre, map.getOrDefault(genre, 0) + 1);
                max = Math.max(max, map.get(genre));
            }

            for (String genre : map.keySet()) {
                if(map.get(genre) == max) {
                    if(!result.containsKey(user)) {
                        result.put(user, new ArrayList<>());
                    }
                    result.get(user).add(genre);
                }
            }
        }

        return result;

    }


    public static void main(String[] args) {
        HashMap<String, List<String>> userToSongs = new HashMap<>();
        userToSongs.put("Malcolm", new ArrayList<>(Arrays.asList("Song1", "Song2", "Song3", "Song4")));
        userToSongs.put("Daisy", new ArrayList<>(Arrays.asList("Song5", "Song6", "Song7")));
        userToSongs.put("Marshall", new ArrayList<>(Arrays.asList("Song8", "Song9", "Song10")));

        HashMap<String, List<String>> genreToSongs = new HashMap<>();

        genreToSongs.put("Rock", new ArrayList<>(Arrays.asList("Song7", "Song5", "Song6", "Song8")));
        genreToSongs.put("Pop", new ArrayList<>(Arrays.asList("Song2", "Song1", "Song9")));
        genreToSongs.put("Jazz", new ArrayList<>(Arrays.asList("Song3", "Song4", "Song10")));
        HashMap<String, List<String>> userToGenre = findFaveGenres(userToSongs, genreToSongs);

        System.out.println(userToGenre);

    }
}
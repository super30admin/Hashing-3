// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class FavoriteGenre {
    // "static void main" must be defined in a public class.
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, String> songToGenreMap = new HashMap<>();
        Map<String, List<String>> result = new HashMap<>();

        //map each song to its genre
        for(String genre : genreMap.keySet()){
            List<String> songs = genreMap.get(genre);

            for(String song : songs){
                songToGenreMap.put(song, genre);
            }
        }

        //create count map to count user song belongigng to a genre
        for(String user : userMap.keySet()){
            Map<String, Integer> countMap = new HashMap<>();
            List<String> favSongs = userMap.get(user);
            int max = 0;
            result.put(user, new ArrayList<>());

            for(String favSong : favSongs){
                String genre = songToGenreMap.get(favSong);
                countMap.put(genre, countMap.getOrDefault(genre, 0) + 1);
                max = Math.max(max, countMap.get(genre));
            }

            for(String genre : countMap.keySet()){
                if(countMap.get(genre) == max){
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

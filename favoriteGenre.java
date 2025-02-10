// Approach : 
// 1.Build a song to genre map - good for O(1) lookup
// 2. For every user build a count of genre map

public class Main {

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        HashMap<String, List<String>> res = new HashMap<>();

        // Song to genre map
        HashMap<String, String> songstoGenre = new HashMap<>();
        for(String genre: genreMap.keySet()){
            List<String> songs = genreMap.get(genre);
            for(String song:songs){
                map.put(song,genre);
            }
        }

        // Genre Count Map
        HashMap<String,>
        for(String user: userMap.keySet()){
            
        }

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

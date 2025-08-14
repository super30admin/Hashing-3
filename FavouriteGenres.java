// TC: O(n * m) users * songs
// SC: O(m) m = num of songs
public class Main {

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {

        HashMap<String, String> songsToGenre = new HashMap<String, String>();
        Map<String, List<String>> resultMap = new HashMap<String, List<String>>();

        for(String currentGenre : genreMap.keySet()){
            for(String song : genreMap.get(currentGenre)){
                songsToGenre.put(song, currentGenre);
            }
        }

        for(String user : userMap.keySet()){
            int max = 0;
            List<String> favGenreList = new ArrayList<String>();
            HashMap<String, Integer> usersGenreCount = new HashMap<>();
            List<String> songs = userMap.get(user);

            for(String song: songs){
                String genre = songsToGenre.get(song);
                if(!usersGenreCount.containsKey(genre)){

                    usersGenreCount.put(genre, 0);
                }
                usersGenreCount.put(genre, usersGenreCount.get(genre) +1);
                max = Math.max( max, usersGenreCount.get(genre));
            }

            for(String genre : usersGenreCount.keySet()){
                if(max == usersGenreCount.get(genre)){
                    favGenreList.add(genre);
                }
            }

            resultMap.put(user, favGenreList);
        }

        return resultMap;

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

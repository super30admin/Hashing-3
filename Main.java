import java.util.*;
import java.util.Map.Entry;
public class Main {

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        HashMap<String, String> songToGenre = new HashMap<>();
        for(String genre: genreMap.keySet()){
            List<String> songs = genreMap.get(genre);
            for(String song: songs){
                songToGenre.put(song, genre);
            }
        }
        HashMap<String, HashMap<String,Integer>> personToGenresCount = new HashMap<>();
        for(String user: userMap.keySet()){
            List<String> songs = userMap.get(user);
            for(String song: songs){
                String genre = songToGenre.get(song);
                if(!personToGenresCount.containsKey(user)){
                    personToGenresCount.put(user, new HashMap<>());
                }
                HashMap<String, Integer> countGenre = personToGenresCount.get(user);
                countGenre.put(genre, countGenre.getOrDefault(genre, 0) + 1);
                personToGenresCount.put(user, countGenre);
            }
        }
        HashMap<String, List<String>> result = new HashMap<>();
        for(Entry<String, HashMap<String, Integer>> user: personToGenresCount.entrySet()){
            HashMap<String, Integer> genres = user.getValue();
            int maxCount = 0;
            for(String genre: genres.keySet()){
                maxCount = Math.max(maxCount, genres.get(genre));
            }
            for(String genre: genres.keySet()){
                if (genres.get(genre) == maxCount){
                    if(!result.containsKey(user.getKey())){
                        result.put(user.getKey(), new ArrayList<>());
                    }
                    List<String> temp = result.get(user.getKey());
                    temp.add(genre);
                    result.put(user.getKey(), temp);
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
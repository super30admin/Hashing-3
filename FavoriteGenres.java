// Time Complexity : O(G*S)+O(U*(avgSongsPerUser+G))
// Space Complexity : O(S+G) 
// Did this code successfully run on Leetcode : yes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteGenres {
    
    private static HashMap<String, List<String>> favGenre(HashMap<String, List<String>> userMap, HashMap<String, List<String>> genreMap){
        HashMap<String, List<String>> output = new HashMap<>();
        HashMap<String, String> songGenre = new HashMap<>();

        for(Map.Entry<String, List<String>> entry : genreMap.entrySet()){
            for(String song : entry.getValue()){
                songGenre.put(song, entry.getKey());
            }
        }

        for(Map.Entry<String, List<String>> entry : userMap.entrySet()){
            List<String> favGenres = new ArrayList<>();
            HashMap<String, Integer> genreCount = new HashMap<>();
            int maxVal = 0;
            for(String song : entry.getValue()){
                String genre = songGenre.get(song);
                genreCount.put(genre, genreCount.getOrDefault(genre,0)+1); 

                if(genreCount.get(genre)>maxVal)
                    maxVal = genreCount.get(genre); 
            }

            for(String genre : genreCount.keySet()){
                if(genreCount.get(genre)==maxVal)
                    favGenres.add(genre);
            }

            output.put(entry.getKey(), favGenres);
        }

        return output;
    }

    public static void main(String[] args){
        HashMap<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", new ArrayList<String>(Arrays.asList("song1", "song2", "song3", "song4", "song8")));
        userSongs.put("Emma", new ArrayList<String>(Arrays.asList("song5", "song6", "song7")));
        
        HashMap<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", new ArrayList<String>(Arrays.asList("song1", "song3")));
        songGenres.put("Dubstep", new ArrayList<String>(Arrays.asList("song7")));
        songGenres.put("Techno", new ArrayList<String>(Arrays.asList("song2", "song4")));
        songGenres.put("Pop", new ArrayList<String>(Arrays.asList("song5", "song6")));
        songGenres.put("Jazz", new ArrayList<String>(Arrays.asList("song8", "song9")));
        
        HashMap<String, List<String>> output = favGenre(userSongs, songGenres);
        
        output.forEach((user, genres) -> {
            StringBuilder sb = new StringBuilder();
            for(String genre : genres){
                sb.append(genre);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(user+"-"+ sb.toString());
        });
    }
}

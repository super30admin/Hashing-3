// Time Complexity : O(p(m+n)) where is m is number of song and n is no of genre, p is no of user
// Space Complexity : O(m+n)

// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
public class Main {
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        HashMap<String,List<String>> result = new HashMap<>();
        HashMap<String, String> songtoGenre = new HashMap<>();
        //Reverse map of song to genre
        for(String genre:genreMap.keySet())
        {
            for(String song:genreMap.get(genre))
            {
                songtoGenre.put(song,genre);
            }
        }

        HashMap<String,Integer> count;
        int max =0;
        for(String user:userMap.keySet())
        {
            count = new HashMap<>();
            //count the favourite genre
            for(String song:userMap.get(user))
            {
                String genre = songtoGenre.get(song);
                count.put(genre,count.getOrDefault(genre,0)+1);
                max = Math.max(max,count.get(genre));
            }
            result.put(user,new ArrayList<>());
            //put element onto the result
            for(String genre:count.keySet())
            {
                if(count.get(genre)==max)
                {
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
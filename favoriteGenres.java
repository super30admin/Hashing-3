//Let's assume
//n is the number of users
//g is the number of genres
//s is the number of average songs in a user playlist
//time complexity O(ns) + O(s(s+g))
//space complexity O(2n+ g + s)

// "static void main" must be defined in a public class.

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import java.lang.Math;

class Solution {
    public Map<String, List<String>> favouriteGenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        HashMap<String, List<String>> result = new HashMap<>();
        HashMap<String, String> songToGenre = new HashMap<>();
        HashMap<String, List<String>> resultMap = new HashMap<>();
        for(String genre: genreMap.keySet()){//O(ns) time
            List<String> songsList = genreMap.get(genre);
            for(String song: songsList){
                songToGenre.put(song, genre);
            }
        }
        HashMap<String, List<String>> ResultMap = new HashMap<>();
        HashMap<String, Integer> countMap;
        for(String user: userMap.keySet()){//O(n(s+g)) time
            int max = 0;
            countMap = new HashMap<>();
            resultMap.put(user, new ArrayList<>());
            List<String> songsList = userMap.get(user);
            for(String song: songsList){//O(s) time
                String genre = songToGenre.get(song);
                countMap.put(genre, countMap.getOrDefault(genre, 0) + 1);
                max = Math.max(countMap.get(genre), max);
            }
            for(String genre: countMap.keySet()){//O(g) time
                int count = countMap.get(genre);
                if(count == max){
                    resultMap.get(user).add(genre);
                }
            }
        }
        return resultMap;
    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> userSongs = new HashMap<>();
        List<String> list1 = Arrays.asList("song1", "song2", "song3", "song4", "song8");
        List<String> list2 = Arrays.asList("song5", "song6", "song7");
        userSongs.put("David", list1);
        userSongs.put("Emma", list2);

        Map<String, List<String>> songGenres = new HashMap<>();
        List<String> list3 = Arrays.asList("song1", "song3");
		List<String> list4 = Arrays.asList("song7");
		List<String> list5 = Arrays.asList("song2", "song4");
		List<String> list6 = Arrays.asList("song5", "song6");
		List<String> list7 = Arrays.asList("song8", "song9");
		songGenres.put("Rock", list3);
		songGenres.put("Dubstep", list4);
		songGenres.put("Techno", list5);
		songGenres.put("Pop", list6);
		songGenres.put("Jazz", list7);

//      Map<String, List<String>> userSongs = new HashMap<>();
// 		List<String> list1 = Arrays.asList("song1", "song2");
// 		List<String> list2 = Arrays.asList("song3", "song4");
// 		userSongs.put("David", list1);
// 		userSongs.put("Emma", list2);

// 		Map<String, List<String>> songGenres = new HashMap<>();

        System.out.println(new Solution().favouriteGenre(userSongs, songGenres));
    }
}

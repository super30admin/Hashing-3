

import java.util.*;


/*
Time Complexity: O(MK1 + NL2) for HASHING
Space Complexity: O(MK1 + NL2)) for HASHING
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
*/

/**
 * 
 * Algos Steps
 * 1. For Each Song And Genres List ,create a dictionary of Song and Genres Pair
 * 2. For Each user perform the perform following steps
 *      a.) Pop out list songs for the given user.
 *      b.) Now iterate over song list and do following
 *          i.) For Each songs,find its corresponding genres in SongGenre Dictionary
 *          ii.) Maintain a dictionary of Genres and Count.Let say count be Dictionary
 *          iii.) Now store the genre and its count in count Dictionary found in Step II
 *          iv. Also maintain a maxFrequency variable.It will store the genre with highest frequency
 *          v.) Now iterate over count Dictionary and look for genes whose frequency matching the maxFequency.
 *          v.) Once we found the maxFrequency genres,append to the output with given user
 *     c.) Keep repeating above steps until all users are processed
 * 
 * 
 * 
 */
public class FavouriteGenres {
    public Map<String, List<String>> favGenres(Map<String,List<String>> userSongs,Map<String,List<String>> songGenres){
        Map<String,List<String>> result = new HashMap<>();
        Map<String,String> songGenre = new HashMap<>();

        for(String genres : songGenres.keySet()){
            List<String> songs = songGenres.get(genres);
            for(String song : songs){
                songGenre.put(song,genres);
            }
       }

       for(String user : userSongs.keySet()){
           result.put(user,new ArrayList<>());
           List<String> songs = userSongs.get(user);
           HashMap<String,Integer> count = new HashMap<>();
           int max = 0;
           for(String song : songs ){
               String g = songGenre.get(song);
               int newCount = count.getOrDefault(g, 0) + 1;
               max = Math.max(max,newCount);
               count.put(g,newCount);
           }
           for(String genre : count.keySet()){
               if(count.get(genre) == max){
                   result.get(user).add(genre);
               }
           }
       }
        return result;
    }

    public static void main(String args[]){
        FavouriteGenres genres = new FavouriteGenres();
        Map<String,List<String>> userSongs = new HashMap<>();

        userSongs.put("David",Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma",Arrays.asList("song5", "song6", "song7"));
        
        Map<String,List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock",Arrays.asList("song1","song3"));
        songGenres.put("Techno",Arrays.asList("song2", "song4"));
        songGenres.put("Dubstep",Arrays.asList("song7"));
        songGenres.put("Pop",Arrays.asList("song5", "song6"));
        songGenres.put("Jazz",Arrays.asList("song8", "song9"));

        System.out.println(genres.favGenres(userSongs, songGenres));

    }
}

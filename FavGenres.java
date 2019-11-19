//Time: O(U * L) where U is the number of users, and L is the average number of songs for each user
//Space: O(S) where S is the total number of songs
//Coded on Leetcode playground
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import java.lang.Math;

class Solution {
    public static Map<String, List<String>> favouriteGenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
//Song to Genre HashMap        
Map<String,String> song_genreMap = songGenre(genreMap);
        //Iterate over each entry in the usersMap
        for(String key : userMap.keySet()){
            //For each entry of the song get the genres from song to genre map and add genre to the list associated to users
            //If all songs have been checked make a new entry to the output map after extracting the ones with maximum frequency using the getmaxGenres function
            userMap.put(key,getmaxGenres(userMap.get(key),song_genreMap));
        }
        
        return userMap;

    }
    
    public static Map<String,String> songGenre(Map<String,List<String>> genreMap){
        Map<String,String> map = new HashMap<String,String>();
        for(String key : genreMap.keySet()){
            List<String> songs = genreMap.get(key);
            for(int i=0;i<songs.size();++i){
                map.put(songs.get(i),key);
            }
        }
        
        return map;
    }
    
    public static List<String> getmaxGenres(List<String> songs, Map<String,String> song_genre){
        
        int max=-1; List<String> max_songs_list = new ArrayList<String>(); 
        
        Map<String,Integer> map = new HashMap<String,Integer>();
        
        for(int i=0;i<songs.size();++i){
            String song=songs.get(i);
            String genre =song_genre.get(song);
            
            if(map.containsKey(genre)){
                map.put(genre,map.get(genre)+1);
            }
            else{
                map.put(genre,1);
            }
            
            if(map.get(genre)==max){
                if(!max_songs_list.contains(genre)){
                    max_songs_list.add(genre);
                }
                
            }
            else if(map.get(genre)>max){
                max=map.get(genre);
                    max_songs_list.clear();
                    max_songs_list.add(genre);
                
                
            }
        }
        
        return max_songs_list ;
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
        
        
        System.out.println(new Solution().favouriteGenre(userSongs, songGenres));
    }
}
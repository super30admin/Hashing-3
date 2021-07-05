//Time complexity:O(N+M) where N is the number of users and M is the number of songs.
//Space Complexity:O(N^2) each user will need an additional hashmap to store the genre counts
//Approach- Create a one-one song-genre map from genre song map. For each user , Iterate over the list of songs to find the genres and their count. Also keep track of max value. Then find all the genres that are equal to the max value and add them to the final list. Finally add the users and the list of genres to the resultant hashmap.

//This code was executed successfully in leetcode playground.

import java.io.*;
import java.util.*;


class Solution {
    
    public Map<String,List<String>> favoriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres){
        Map<String,List<String>> res=new HashMap<>();
        Map<String,String> sgmap=new HashMap<>();
        
        for(String g:songGenres.keySet()){
            List<String> temp=songGenres.get(g);
            
            for(String s : temp){
                sgmap.put(s,g);
            }
        }
        for(String u: userSongs.keySet()){
            List<String> temp=userSongs.get(u);
            Map<String,Integer> genCount=new HashMap<>();
            int max=0;
            for(String s: temp){
                String g=sgmap.get(s);
                genCount.put(g,genCount.getOrDefault(g,0)+1);
                max=Math.max(max,genCount.get(g));
            }
            List<String> temp2=new ArrayList<>();
            for(String g: genCount.keySet()){
                if(genCount.get(g)==max){
                    temp2.add(g);
                }
            }
            res.put(u,temp2);
        }
        return res;
        
    }
    
	public static void main (String[] args) {
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
        System.out.println(new Solution().favoriteGenres(userSongs, songGenres));
	    
	
	}
}
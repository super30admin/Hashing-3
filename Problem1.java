//time complexity-O(n^2 + n^2)
//Space complexity-O(2*n)
//Ran on leetcode-Yes
//Solution with comments-
        /*package whatever //do not write package name here */        /*package whatever //do not write package name here */

        import java.io.*;
        import java.util.*;
        
        class GFG {
            public static void main (String[] args) {
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
            public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
                Map<String, List<String>> out = new HashMap<>();
                HashMap<String,String> songs= new HashMap<>();
                for(String genre : genreMap.keySet()){
                    List<String> song= genreMap.get(genre);
                    for(String k : song){
                        songs.put(k,genre);
                    }
                }
                Map<String, Integer> count;
                int max=0;
                for(String user: userMap.keySet()){
                    count= new HashMap<>();
                    max=0;
                    out.put(user, new ArrayList<>());
                    List<String> userSongs= userMap.get(user);
                    for(String s: userSongs){
                        String genre= songs.get(s);
                        count.put(genre,count.getOrDefault(genre,0)+1);
                        int c=count.get(genre);
                        max=Math.max(max,c);
                    }
                    for(String g : count.keySet()){
                        if(count.get(g)==max)
                            out.get(user).add(g);
                    }
                    
                }
                return out;
                
            }
        
        }
        
        
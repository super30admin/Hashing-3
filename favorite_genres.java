class Main{
    public static Map<String, List<String>> favoriteGenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap){
        HashMap<String, String> songsToGenre = new HashMap<>();
        HashMap<String, List<String>> result = new HashMap<>();
        
        for(String genre: genreMap.keySet()){
            List<String> songs = genreMap.get(genre);
            for(String song: songs){
                songsToGenre.put(song, genre);
            }
        }
      
        HashMap<String, Integer> count;
        int max = 0;
        
        for(String user: userMap.keySet()){
            count = new HashMap<>();
            max = 0;
            result.put(user, new.ArrayList<>());
            List<String> songs = userMap.get(user); 
            
            for(String song: songs){
                String genre = songsToGenre.get(song);
                count.put(genre, count.getOrDefault(genre, 0) + 1);
                max = Math.max(max, count.get(genre));
            }
            
            for(String genre: count.keySet()){
                if(count.get(genre) == max){
                    result.get(user).add(genre);
                }
            }
        }
      return result;
    }
  
  //TC: O(user * (song * genre))
  
  //SC: O(n * m + m * s) 
  
  //n -> number of users,
  //m -> amount of genres, 
  //s -> number of songs.


        
  
    

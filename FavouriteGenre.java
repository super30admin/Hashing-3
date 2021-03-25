// "static void main" must be defined in a public class.
//TC:O(M+NK)-> M: no.of songs, N: no. of users, K: no. of genres
//SC:O(M)
//Did it run successfully on Leetcode? :Yes
public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> userSongs = new HashMap();
        Map<String, List<String>> songGenres = new HashMap();
        userSongs.put("David", new ArrayList());
        userSongs.get("David").add("song1");
        userSongs.get("David").add("song2");
        userSongs.get("David").add("song3");
        userSongs.get("David").add("song4");
        userSongs.get("David").add("song8");
        userSongs.put("Emma", new ArrayList());
        userSongs.get("Emma").add("song5");
        userSongs.get("Emma").add("song6");
        userSongs.get("Emma").add("song7");
        songGenres.put("Rock", new ArrayList());
        songGenres.get("Rock").add("song1"); 
        songGenres.get("Rock").add("song3");  
        songGenres.put("Dubstep", new ArrayList());
        songGenres.get("Dubstep").add("song7");
        songGenres.put("Techno", new ArrayList());
        songGenres.get("Techno").add("song2");
        songGenres.get("Techno").add("song4");
        songGenres.put("Pop", new ArrayList());
        songGenres.get("Pop").add("song5");
        songGenres.get("Pop").add("song6");
        songGenres.put("Jazz", new ArrayList());
        songGenres.get("Jazz").add("song8");
        songGenres.get("Jazz").add("song9");
        System.out.println(getFavoriteGenre(userSongs, songGenres));
    }
   public static HashMap<String, List<String>> getFavoriteGenre( Map<String, List<String>> userSongs, Map<String, List<String>> songGenres){
        HashMap<String, List<String>> result = new HashMap();
        HashMap<String, String> songToGenre = new HashMap();
        for (String genre: songGenres.keySet()){
            List<String> songs = songGenres.get(genre);
            for (String song : songs){
                if (!songToGenre.containsKey(song)){
                    songToGenre.put(song, genre);
                }
            }
        }
       HashMap<String, Integer> count;
       for (String user : userSongs.keySet()){
           int max = 0;
           count = new HashMap();
           result.put(user, new ArrayList());
           List<String> songs = userSongs.get(user);
           if (songs != null){
               for(String song : songs){
                   String genre = songToGenre.get(song);
                   count.put(genre, count.getOrDefault(genre, 0) + 1);
                   int c = count.get(genre);
                   max = Math.max(max, c);
               }
               for (String genre: count.keySet()){
                   if (count.get(genre) == max){
                       result.get(user).add(genre);
                   }
               }
           }
       }
        return result;
    }
 }


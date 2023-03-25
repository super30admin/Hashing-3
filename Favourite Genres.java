// "static void main" must be defined in a public class.
public class Main {
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, String> song_to_genre = new HashMap<>();
        
        //go over the genreMap
        
        for(Map.Entry<String, List<String>> e : genreMap.entrySet()){
            
            List<String> songs = e.getValue();
            for(String song : songs){
                
                song_to_genre.put(song, e.getKey());
                
            }
            
        }
        
        System.out.println(song_to_genre);
        
        HashMap<String, List<String>> user_genre = new HashMap<>();
        for(Map.Entry<String, List<String>> e: userMap.entrySet()){
            
            List<String> songs = e.getValue();
            HashMap<String, Integer> genre_count = new HashMap<>();
            int max_freq = Integer.MIN_VALUE;
            for(String song : songs){
                String genre = song_to_genre.get(song);
                genre_count.put(genre, genre_count.getOrDefault(genre, 0) + 1);
                max_freq = Math.max(max_freq, genre_count.get(genre));
            }
            
            
            
            //go over the genre frequency map. 
            List<String> max_genres = new LinkedList<>();
            for(Map.Entry<String, Integer> f_e: genre_count.entrySet()){
                
                int count = f_e.getValue();
                if(count == max_freq){
                    max_genres.add(f_e.getKey());
                }
                
            }
            user_genre.put(e.getKey(), max_genres);
            
        }
        
        //go over user_genre map to collect the frequent genres. 
        
        for(Map.Entry<String, List<String>> e : user_genre.entrySet()){
            
            List<String> genres = e.getValue();
            Collections.sort(genres);
            
            int same_count = 0;
            int max_count = Integer.MIN_VALUE;
            
            for(int i = 1; i < genres.size(); i++){
                if(genres.get(i - 1) == genres.get(i)){
                    same_count ++;
                }
                
                else{
                    if(max_count < same_count){
                        max_count = same_count;
                    }
                }
            }
            
        }
        
        return user_genre;
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
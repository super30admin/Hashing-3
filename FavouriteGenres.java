public class Main {

    // Time Complexity: O(g*s + n * (m + q))    (g -> no.of genres, s -> no.of songs per genre, n -> no. of users, m -> max. no. of songs each user listens, q -> max no. of genres generated for each user)
    // Space Complexity: O(no. of unique songs)
    
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, List<String>> result = new HashMap<>();
        HashMap<String,String> songToGenre = new HashMap<>();

        // Populating a Song -> Genre map
        for(String genre : genreMap.keySet()){  // g*s
            List<String> songs = genreMap.get(genre);
            for(String song : songs){
                songToGenre.put(song, genre);
            }
        }
                
        Map<String, Integer> genreCount;
        int maxVal = 0;
        
        /*
            For every user:
                - for every song the user listens
                    - get the genre of the song and keep the maxVal for each genre
                - to determine the favourite genre --> add to the result list if the genre frequency == maxVal
        */
        for(String user: userMap.keySet()){
            genreCount = new HashMap<>();
            maxVal = 0;
            result.put(user, new ArrayList<>());
            
            List<String> userSongs= userMap.get(user);
            for(String song : userSongs){
                String genre = songToGenre.get(song);
                genreCount.put(genre, genreCount.getOrDefault(genre,0) + 1);
                int c = genreCount.get(genre);
                maxVal = Math.max(maxVal, c);
            }
            
            for(String genre : genreCount.keySet()){
                if(genreCount.get(genre) == maxVal)
                    result.get(user).add(genre);
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

        Map<String, List<String>> result = favoritegenre(userSongs, songGenres);

        System.out.println(result);
    }
}
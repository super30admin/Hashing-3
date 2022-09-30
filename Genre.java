// "static void main" must be defined in a public class.
public class Main {
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        HashMap<String, List<String>> result = new HashMap<>();
        
        //Step 1 : Remap the genreMap as song to genre
        HashMap<String, String> map = new HashMap<>();
        for(String genres : genreMap.keySet()){
            List<String> songs = genreMap.get(genres);
            for(String song : songs){
                map.put(song, genres);
            }
        }   
        
        //Step 2 : Find the genre frequency for each user by creating individual hashmaps and then finding the max freq genre and adding it to list and add user + list to hashmap
        for(String users : userMap.keySet()){
            List<String> songs = userMap.get(users);
            HashMap<String, Integer> freqMap = new HashMap<>();
            int max = 0;
            for(String song : songs){
                String genre = map.get(song);
                freqMap.put(genre, freqMap.getOrDefault(genre, 0) + 1);
                max = Math.max(max, freqMap.get(genre));
            }
            result.put(users, new ArrayList<>());
            for(String names : freqMap.keySet()){
                if(freqMap.get(names) == max)
                    result.get(users).add(names);
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

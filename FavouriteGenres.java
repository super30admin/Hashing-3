//TC : O(m*n)
//SC : O(n). // Here, n = no of users, m = total no. of songs 

public class Main{
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap,       Map<String, List<String>> genreMap) {
    Map<String, String> songGenreMap = new HashMap<>();
    for(String genre : genreMap.keySet() ){
        List<String> genreSongs = genreMap.get(genre);
        //Now we have songs of genre
        for(String song : genreSongs){
            songGenreMap.put(song, genre); // Creating a hashmap from song ---> genre
        }
    }
    
    Map<String, List<String> > result = new HashMap<>();
    HashMap<String, Integer> freqMap;
    
    for(String user : userMap.keySet() ){
        //Fav. Songs of user
        List<String> listOfSongs = userMap.get(user);
        freqMap = new HashMap<>(); // freq map for each user
        result.put(user, new ArrayList<>());
        int max = 0;
        for(String song : listOfSongs){
            String genre = songGenreMap.get(song);
            int freq = freqMap.getOrDefault(genre, 0);
            freq++;
            max = Math.max(max, freq);
            freqMap.put(genre, freq);
        }
        
        for(String str : freqMap.keySet()){ // genre with max frequency/count being added in user's fav genre
            if(freqMap.get(str) == max){
                result.get(user).add(str);
            }
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

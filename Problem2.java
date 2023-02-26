// "static void main" must be defined in a public class.

/*

We need to find which Genre the user listens to the most, if there exists more than one genre then add them to the result map as well

The question gives User to Song map and Genre to song map, so we will create a song to genre map , then we will go over each user and identify which genre is the most

Time : Let m be the keys in UserMap , and n be the values , so O(m*n)
Space : O(g) , where g is the size of the genreMap
*/
public class Main {

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        
        // User to Fav Genre Map
        Map<String, List<String>> result = new HashMap<String, List<String>>();
        
        // create Song to Genre map
        HashMap<String,List<String>> songToGenre = new HashMap<String,List<String>>();
        
        for(String genre: genreMap.keySet()){
            List<String> songs = genreMap.get(genre);
            for(String sng : songs){
                if(!songToGenre.containsKey(sng)){
                    songToGenre.put(sng,new ArrayList<String>());
                }
                songToGenre.get(sng).add(genre);
            }
        }
        
        
        for(String usr: userMap.keySet()){
            List<String> songs = userMap.get(usr);
            Map<String, Integer> temp =  new HashMap<String, Integer>(); // Genre to Count Map
            int max = Integer.MIN_VALUE;
            for(String sng : songs){
                String gen = songToGenre.get(sng).get(0); // get the Genre of the Songg
                if(!temp.containsKey(gen)){
                    temp.put(gen,0);
                }
                int count = temp.get(gen); // get the prev count
                count++; // add +1 to it
                max = Math.max(max, count); // check if its the max
                
                temp.put(gen,count++); // increasing the Genre Count
            }
            
            // At this point my temp has the corresponding genre count of the usr, we will go over it to check which genre is max, and add that to the result 
            List<String> mostListenGen = new ArrayList<String>();
            for(String gen : temp.keySet()){
                if(temp.get(gen) == max){
                    mostListenGen.add(gen);
                }
            }
            
            result.put(usr, mostListenGen);
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
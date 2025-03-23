// Time Complexity :O( n( m + k) ) where n is no of users, m is no of songs and k is genres
// Space Complexity :O(m)
// Did this code successfully run on Leetcode :Yes ( not given on leetcode )
// Any problem you faced while coding this : no

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
public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
    HashMap<String, List<String>> result=new HashMap<>();
    HashMap<String,String> songToGenre=new HashMap<>(); //song to genre mapping

    for(String genre:genreMap.keySet()){
        List<String> songs=genreMap.get(genre);
        for(String song:songs){
            songToGenre.put(song,genre);
        }
    }
    HashMap<String,Integer> genreCount; // genre to count mapping
 
    for(String user:userMap.keySet()){
        result.put(user,new ArrayList<>());
        genreCount=new HashMap<>();
        List<String> songs=userMap.get(user);
        int maxFreq=0;
        for(String song:songs){

           String genre=songToGenre.get(song);

            int count=genreCount.getOrDefault(genre,0)+1;

            maxFreq=Math.max(maxFreq,count);
        genreCount.put(genre,count);

        }
        for(String genre:genreCount.keySet()){
            if(genreCount.get(genre)==maxFreq){
                result.get(user).add(genre);
            }
        }

    }
    return result;
}
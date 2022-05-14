// Time Complexity : O((u*n) + n+m) where u = no. of users, n = no. of songs, m = no of genres
// Space Complexity : O(u + n + m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create the map of songs to genres
// Go through all the songs for each user and get its genre and keep count
// At the same time maintain the list of genres of songs which has occured most
// Finally add the user and max genre list to result map. At the end return the result map
public class Main {
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
        Map<String, String> songToGenre = new HashMap<>();
        Map<String, List<String>> result = new HashMap<>(); //user to genre list
        for(String genre: genreMap.keySet()){
            List<String> songs = genreMap.get(genre);
            for(String song: songs){
                songToGenre.put(song, genre);
            }
        }
        for(String user: userMap.keySet()){
            List<String> songs = userMap.get(user);
            List<String> likes = new ArrayList<>();
            //Genre to count
            Map<String, Integer> genreToCount = new HashMap<>();
            int count = 0;
            for(String song: songs){
                String genre = songToGenre.get(song);
                int thisGenreCount = genreToCount.getOrDefault(genre, 0);
                thisGenreCount++;
                if(thisGenreCount > count){
                    likes = new ArrayList<>();
                    likes.add(genre);
                    count = thisGenreCount;
                }
                else if(thisGenreCount == count){
                    likes.add(genre);
                }
                genreToCount.put(genre, thisGenreCount);
            }
            result.put(user, likes);
        }
return result;
}
}

















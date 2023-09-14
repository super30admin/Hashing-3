import java.util.*;
// space complexity : O(n) n = songs 
// time complexity : O(users * n)


/*        
    problem  Favourite Genres

        Given a map Map<String, List> userSongs with user names as keys and a list of all the songs that the user has listened to as values.
        Also given a map Map<String, List> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.
        The task is to return a map Map<String, List>, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.
        Example 1:
        Input:
        userSongs = {

        "David": ["song1", "song2", "song3", "song4", "song8"],

        "Emma": ["song5", "song6", "song7"]

        },

        songGenres = {

        "Rock": ["song1", "song3"],

        "Dubstep": ["song7"],

        "Techno": ["song2", "song4"],

        "Pop": ["song5", "song6"],

        "Jazz": ["song8", "song9"]

        }

        Output: {

        "David": ["Rock", "Techno"],

        "Emma": ["Pop"]

        }

        Explanation:

        David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.

        Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.

*/ 


public class favouritGenres {
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        HashMap<String, String > songToGenre = new HashMap<>();
        // List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> res = new HashMap<>();
        for(String genre : genreMap.keySet()){
            for(String song : genreMap.get(genre)){
                songToGenre.put(song, genre);
            }
        }
        for(String user : userMap.keySet()){
            HashMap<String, Integer> userGenre = new HashMap<>();
            int max = 0;
            res.put(user,new ArrayList<String>());
            for(String song : userMap.get(user)){
                String genre = songToGenre.get(song);
                int curr = userGenre.getOrDefault(genre,0) + 1;
                userGenre.put(genre, curr);
                if(curr>=max){
                    if(curr > max) 
                        res.put(user,new ArrayList<String>());
                    max = curr;
                    res.get(user).add(genre);
                }
            }
        }
        return res;
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





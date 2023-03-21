// "static void main" must be defined in a public class.
class Main {

    //Time Complexity: O(m*n), m = no of users, n = no of songs
    //Space Complexity: O(n)

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {

        Map<String, String> songToGenreMap = new HashMap<>();             //need a hashmap to map song to genre

        for(String genre : genreMap.keySet()){                            //iterate through genreMap

            List<String> songs = genreMap.get(genre);                     //get all the songs

            for(String song: songs){                                      //iterate through songs
                songToGenreMap.put(song, genre);                          //put the song and genre into songToGenreMap
            }
        }

        Map<String, List<String>> result = new HashMap<>();               //to store the result
        Map<String, Integer> countMap = new HashMap<>();                     //create a map to store the count of a genre

        for(String user: userMap.keySet()){                           //iterate through userMap

            result.put(user, new ArrayList<>());                      //put the user and new arraylist into result
            countMap = new HashMap<>();                               //reset the countMap
            List<String>  songs = userMap.get(user);                  //get all the songs that user is listening
            int max = 0;                                              //initialize max is 0

            for(String song: songs){                                  //iterate though all songs
                String genre = songToGenreMap.get(song);              //get the genre of that song
                countMap.put(genre, countMap.getOrDefault(genre, 0) + 1);     //increase the counter of that genre
                max = Math.max(max, countMap.get(genre));             //get the maximum count of a genre
            }

            for(String genre: countMap.keySet()){                     //iterate through countMap

                if(countMap.get(genre) == max){                       //if genre count equal to max
                    result.get(user).add(genre);                      //then add it to the result
                }
            }
        }
        return result;                                                //return the result
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

//Favourite Genres

/*
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

public class FavouriteGenresHashing3 {
}
